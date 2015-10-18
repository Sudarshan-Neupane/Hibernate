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
		Query query = session.createQuery("select id,username from UserCrud");
//		query.setFirstResult(3);
//		query.setMaxResults(4);
//		List<UserCrud> users =(List<UserCrud>) query.list();
//		List<String> userName =(List<String>) query.list();
		List<Object[]> userName =(List<Object[]>) query.list();
		
		session.getTransaction().commit();
		session.close();
		for (Object[] userCrud : userName) {
			Integer id = (Integer)userCrud[0];
			System.out.println(id);
			System.out.println(userCrud[1]);
		}
//		System.out.println("size of the list result " + users.size());
	}
}
