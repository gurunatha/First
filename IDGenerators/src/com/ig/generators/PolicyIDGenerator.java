package com.ig.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class PolicyIDGenerator implements IdentifierGenerator, Configurable {
	private Properties props;

	@Override
	public void configure(Type type, Properties props, Dialect dialect)
			throws MappingException {
		this.props = props;
	}

	@Override
	public Serializable generate(SessionImplementor session, Object obj)
			throws HibernateException {
		int month = 0;
		int year = 0;
		int policySeq = 0;
		String prefix = null;
		String policyId = null;
		Connection con = null;
		Statement stmt = null;
		Calendar calendar = null;

		calendar = Calendar.getInstance();
		month = calendar.get(Calendar.MONTH) + 1;
		year = calendar.get(Calendar.YEAR);
		prefix = props.getProperty("prefix");
		System.out.println("classname : " + obj.getClass().getName());
		try {
			con = session.getJdbcConnectionAccess().obtainConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT POLICY_ID_SEQUENCE.NEXTVAL FROM DUAL");
			if (rs.next()) {
				policySeq = rs.getInt(1);
			}
			policyId = prefix + policySeq + "-" + month + "-" + year;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return policyId;
	}

}
