package com.teja;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.entity.Cart;
import com.teja.entity.Orders;
import com.teja.entity.User;

public class Update {

	public static void main(String[] args) {
		//Creating Session Factory
    	SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Orders.class)
				.buildSessionFactory();
    	
    	//Creating a Current Session
    	Session session = factory.getCurrentSession();
    	
    	session.beginTransaction();
    	
    	User user = session.get(User.class,"cf38a3bc-74c9-409c-bf64-f9824855e960");
    	user.setEmail("tejayerraguntla9@gmail.com");
//    	user.setId("cf38a3bc-74c9-409c-bf64-f9824855e987");
    	//Commiting Current Session
    	session.getTransaction().commit();
    	// Closing Current Session
    	session.close();

	}

}
