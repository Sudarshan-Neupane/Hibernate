package org.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.crud.UserCrud;

public class MainCrud {
	public static void main(String[] args) {
		int i;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		for(i=0;i<10;i++){
			UserCrud uc = new UserCrud();
			uc.setUsername("username "+i);
			session.save(uc);
		}
		session.getTransaction().commit();
		session.close();
	
	}

}