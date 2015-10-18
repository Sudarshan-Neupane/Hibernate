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
		// when we simply pass this it will execute so it is dangerous
		// String id1 =" 6 or 2=2";
		// Query query =
		// session.createQuery("select id,username from UserCrud where id>"+id1);
		String id1 = "1";
		// Query query = session.createQuery("from UserCrud where id> ?");
		// query.setInteger(0, Integer.parseInt(id1));
		// WE CAN ALSO DO LIKE THIS
		String uname = "username 5";
		Query query = session.createQuery("from UserCrud where id> :userId and username=:un");
		query.setInteger("userId", Integer.parseInt(id1));
		query.setString("un",uname);

		List<UserCrud> userName = (List<UserCrud>) query.list();

		session.getTransaction().commit();
		session.close();
		for (UserCrud userCrud : userName) {
			System.out.println(userCrud.getUsername());
		}
	}
}
