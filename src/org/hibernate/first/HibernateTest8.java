package org.hibernate.first;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.first.dto.Address;
import org.hibernate.first.dto.UserDetails;
import org.hibernate.first.dto.UserDetails8;

public class HibernateTest8 {
	public static void main(String[] args) {

		UserDetails8 us8 = new UserDetails8();
		us8.setUserName("first Name");
		Address address = new Address();
			address.setCity("Fairfield");
			address.setPincode("123456789");
			address.setState("IOWA");
			address.setStreet("4 TH street");
		us8.setAddress(address);
		Address address1 = new Address();
			address1.setCity("chicago");
			address1.setPincode("123456789");
			address1.setState("Illonoies");
			address1.setStreet("4 TH street");
		us8.setOfficeAddress(address1);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(us8);
		
		session.getTransaction().commit();
		session.close();
		//retrieve address of id 1
		us8 =null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		us8 = session.get(UserDetails8.class, 1);
		System.out.println(" User city returieve "+us8.getAddress().getCity());

	}
}
