package org.hibernate.first;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.first.dto.AddressCollection;
import org.hibernate.first.dto.UserDetails;
import org.hibernate.first.dto.UserDetailsCollection;

public class AddressCollectionMain {
	public static void main(String[] args) {
		UserDetailsCollection udc = new UserDetailsCollection();
		udc.setUserName("first Name");
		AddressCollection address = new AddressCollection();
			address.setCity("Fairfield");
			address.setPincode("123456789");
			address.setState("IOWA");
			address.setStreet("4 TH street");
	   udc.getListOfAddress().add(address);
	   AddressCollection address1 = new AddressCollection();
			address1.setCity("chicago");
			address1.setPincode("123456789");
			address1.setState("Illonoies");
			address1.setStreet("4 TH street");
			udc.getListOfAddress().add(address1);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(udc);
		
		session.getTransaction().commit();
		session.close();
		//retrieve address of id 1
		udc =null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		udc = session.get(UserDetailsCollection.class, 0);
		
		Set<AddressCollection> addressSet=udc.getListOfAddress();
		for (AddressCollection addressCollection : addressSet) {
			System.out.println(addressCollection.getCity());
			
		}	

	}
}
