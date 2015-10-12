package org.hibernate.relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.relations.dto.UserDetailsEntity;
import org.hibernate.relations.dto.Vehicle;

public class OneToManyMain {
	public static void main(String[] args) {
		UserDetailsEntity ude = new UserDetailsEntity();
		ude.setUsername("Brains");
			
		Vehicle vc = new Vehicle();
		vc.setVehicleName("Car");
		
		Vehicle vc1 = new Vehicle();
		vc1.setVehicleName("Car");
		
		ude.getVehicle().add(vc);
		ude.getVehicle().add(vc1);
		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(ude);
		session.save(vc);
		session.save(vc1);
		session.getTransaction().commit();
		session.close();
		
	}
}
