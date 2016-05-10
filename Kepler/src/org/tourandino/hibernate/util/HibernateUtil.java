package org.tourandino.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
    private SessionFactory sessionFactory;

	public HibernateUtil()
    {
    	try{
    		//File f = new File("D://Hibernate/test/hibernate.cfg.xml");
    		//sessionFactory = new Configuration().configure(f).buildSessionFactory();
    		sessionFactory = new Configuration().configure("/org/tourandino/hibernate/cfg/hibernate.cfg.xml").buildSessionFactory();
    	}
    	catch (Throwable ex) {
    		System.err.println("Failed to create sessionFactory object." + ex);
    		throw new ExceptionInInitializerError(ex);
    	}
      
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
