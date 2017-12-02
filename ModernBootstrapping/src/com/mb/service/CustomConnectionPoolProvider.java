package com.mb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.spi.Startable;
import org.hibernate.service.spi.Stoppable;

public class CustomConnectionPoolProvider implements ConnectionProvider,
		ConfigurationService, Startable, Stoppable {

	@Override
	public boolean isUnwrappableAs(Class arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T cast(Class<T> arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getSetting(String arg0, Class<T> arg1, T arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getSetting(String arg0, Converter<T> arg1, T arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getSetting(String arg0, Converter<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		System.out.println("connection closed");
		con.close();
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("connection created");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "next_gen_auto_sys",
				"welcome1");
		con.setAutoCommit(false);

		return con;
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
