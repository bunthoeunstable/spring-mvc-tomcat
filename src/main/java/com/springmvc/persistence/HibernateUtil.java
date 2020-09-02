package com.springmvc.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	
	static {
		try {
			buildSessionFactory();
		}catch(Exception e){
			System.err.println("Exception while initializing hibernate util.. ");
			e.printStackTrace();
		}
	}

    private static void buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException {
    	 
        Session retSession=null;
            try {
                retSession=sessionFactory.openSession();
            }catch(Throwable t){
            System.err.println("Exception while getting session.. ");
            t.printStackTrace();
            }
            if(retSession == null) {
                System.err.println("session is discovered null");
            }
            return retSession;
    }
    

}
