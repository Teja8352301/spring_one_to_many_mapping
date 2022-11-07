package com.teja;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.entity.Cart;
import com.teja.entity.Orders;
import com.teja.entity.User;

public class Save 
{
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
    	
//    	User user = new User();
//    	user.setEmail("yerraguntlateja4@gmail.com");
//    	user.setUserName("Teja Yerraguntla");
    	
    	User user = session.get(User.class,"cf38a3bc-74c9-409c-bf64-f9824855e960");
    	
    	Orders order = new Orders();
    	order.setOrderItemsCount(0);
    	order.setTotalPrice(0);
    	order.setUserId(user);
    	user.addOrder(order);
    	session.save(order);
    	
    	//Commiting Current Session
    	session.getTransaction().commit();
    	// Closing Current Session
    	session.close();
    }
}
