package com.teja;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.entity.Cart;
import com.teja.entity.Orders;
import com.teja.entity.User;

public class Get {
	public static void main( String[] args )
    {
    	//Creating Session Factory
    	SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Orders.class)
				.buildSessionFactory();
    	
    	//Creating a Current Session
    	Session session = factory.getCurrentSession();
    	
    	session.beginTransaction();
    	
//    	User user = session.get(User.class, 2);
//    	
//    	System.out.println(user.getOrders());
    	
//    	Bi-DIRECTIONAL--------
    	
    	Orders order = session.get(Orders.class, "2d945625-34a2-4530-a687-ca0a132bc5f6");
    	System.out.println(order);
    	System.out.println(order.getUserId());
    	System.out.println(order.getUserId().getOrders());
    	
    	//Commiting Current Session
    	session.getTransaction().commit();
    	// Closing Current Session
    	session.close();
    }

}
