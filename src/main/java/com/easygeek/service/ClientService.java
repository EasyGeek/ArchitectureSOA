package com.easygeek.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.Client;

@Service
public class ClientService extends CoreDao<Client>{

	
	public ClientService() {
		super(Client.class);
	}
	
	public boolean connexion(String email, String password) throws UnsupportedEncodingException{
		Criteria query = session.createCriteria(Client.class)
				.add(Restrictions.eq("password", java.net.URLDecoder.decode(password, "UTF-8")))
				.add(Restrictions.eq("email", java.net.URLDecoder.decode(email, "UTF-8")));

		List<Client> clients = query.list();
		
		if (clients.size() > 0)
			return true;
		else
			return false;
	}
	
	public Serializable delete(Client obj) {
	    session.beginTransaction();
	    try { 
	     session.delete(obj);
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    }
	    
	    session.getTransaction().commit();
	  return (Serializable) obj;
	}
	 
	public Serializable update(Client obj) {
        session.beginTransaction();
        try { 
         session.update(obj);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        session.getTransaction().commit();
        return (Serializable) obj;
	}
}