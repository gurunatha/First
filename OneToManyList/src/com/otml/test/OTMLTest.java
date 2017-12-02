package com.otml.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otml.entities.Appointment;
import com.otml.entities.Doctor;
import com.otml.util.HibernateUtil;

public class OTMLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Doctor doctor = null;
		Appointment appointment = null;
		List<Appointment> appointments = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			appointment = new Appointment();
			appointment.setAppointmentDate(new Date());
			appointment.setPatientName("Sam");
			appointment.setContactNo("92337234");
			appointment.setComments("Emergency");
			session.save(appointment);

			appointments = new ArrayList<Appointment>();
			appointments.add(appointment);

			appointment = new Appointment();
			appointment.setAppointmentDate(new Date());
			appointment.setPatientName("Rod");
			appointment.setContactNo("92337353234");
			appointment.setComments("Regular Checkup");
			session.save(appointment);
			appointments.add(appointment);

			doctor = new Doctor();
			doctor.setName("Raghupati");
			doctor.setSpecialization("Cardiac");
			doctor.setQualification("MS");
			doctor.setExperience(35);
			doctor.setEmail("raghupati@gmail.com");
			doctor.setMobile("3938394");
			doctor.setAppointments(appointments);
			session.save(doctor);

			appointment = new Appointment();
			appointment.setAppointmentDate(new Date());
			appointment.setPatientName("Mathew");
			appointment.setContactNo("92234");
			appointment.setComments("Regular Checkup");
			session.save(appointment);
			appointments = new ArrayList<Appointment>();
			appointments.add(appointment);

			doctor = new Doctor();
			doctor.setName("K Y reddy");
			doctor.setSpecialization("Orthopetic");
			doctor.setQualification("DH");
			doctor.setExperience(35);
			doctor.setEmail("kyreddy@gmail.com");
			doctor.setMobile("3938394");
			doctor.setAppointments(appointments);
			session.save(doctor);

			/*doctor = (Doctor) session.get(Doctor.class, 1);
			System.out.println(doctor);*/
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			HibernateUtil.closeSessionFactory();
		}

	}
}
