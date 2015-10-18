package org.hibernate.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ParameterPass {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		int id1 =8;
		Query query = session.createQuery("select id,username from UserCrud where id>"+id1);
		List<Object[]> userName =(List<Object[]>) query.list();
		
		session.getTransaction().commit();
		session.close();
		for (Object[] userCrud : userName) {
			Integer id = (Integer)userCrud[0];
			System.out.println(id);
			System.out.println(userCrud[1]);
		}
	}
}
