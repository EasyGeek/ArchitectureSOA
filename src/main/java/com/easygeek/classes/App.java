package com.easygeek.classes;


import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;

/**
 * Hello world!
 *
 */
@Entity
public class App 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory()
        							   .openSession();
        session.beginTransaction();
		List<Client> result = (List<Client>) session.createQuery("from Client").list();
        session.getTransaction().commit();
        
        for(Client f : (List<Client>)result)
        {
        	System.out.println(f.getNom() + " " + f.getPrenom());
        }     
    }
}
