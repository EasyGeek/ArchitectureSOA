package com.easygeek.dao;


import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.easygeek.classes.Client;
import com.easygeek.classes.HibernateUtil;

@Repository
public class Exemple 
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
