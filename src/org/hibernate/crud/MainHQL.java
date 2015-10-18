package org.hibernate.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHQL {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserCrud");
		query.setFirstResult(3);
		query.setMaxResults(4);
		List<UserCrud> users =(List<UserCrud>) query.list();
		session.getTransaction().commit();
		session.close();
		for (UserCrud userCrud : users) {
			System.out.println(userCrud.getUsername());
		}
		System.out.println("size of the list result " + users.size());
	}
}
