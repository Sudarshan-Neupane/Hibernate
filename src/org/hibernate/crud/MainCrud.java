package org.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.crud.UserCrud;

public class MainCrud {
	public static void main(String[] args) {
		int i;
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		// for(i=0;i<10;i++){
		// UserCrud uc = new UserCrud();
		// uc.setUsername("username "+i);
		// session.save(uc);
		// }
		UserCrud user = (UserCrud) session.get(UserCrud.class, 2);
//		session.delete(user);
//		System.out.println("User name pulled up id " + user.getUsername());
		//For updating the user name
		user.setUsername("updated username1 ");
		//update
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

}
