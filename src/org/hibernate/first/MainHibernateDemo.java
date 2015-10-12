package org.hibernate.first;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.first.dto.UserDetails;

public class MainHibernateDemo {
public static void main(String[] args) {
	UserDetails ud = new UserDetails();
	ud.setUserId(1);
	ud.setUserName("Sudarshan1");
	ud.setJoinDate(new Date());
	ud.setAddress("Nepal");
	ud.setDescription("This is the first description");
	//build session factor ==build session
	SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	//new Transation is created;
	session.beginTransaction();
	session.save(ud);
	//session commit
	session.getTransaction().commit();
	session.close();
	
	//second 
	//retrieve data form database
	ud =null;
	session = sessionFactory.openSession();
	session.beginTransaction();
	ud = session.get(UserDetails.class, 1);
	System.out.println(" User name returieve "+ud.getUserName());
	
	
}
}
