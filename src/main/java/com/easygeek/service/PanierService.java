package com.easygeek.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.easygeek.entite.Client;
import com.easygeek.entite.Commande;
import com.easygeek.entite.TypeLivraison;
import com.easygeek.util.HibernateUtil;

@Service
public class PanierService extends CoreService<Commande>{
	
	ClientService clientService = new ClientService();
	
	public PanierService() {
		super(Commande.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Commande> getCommandes(Integer idClient){
		
		Criteria criteria =  session.createCriteria(Commande.class).add(Restrictions.eq("client", clientService.get(idClient)));
		criteria.setFetchMode("Client", FetchMode.JOIN);
		
		List<Commande> list = criteria.list();
		criteria.setFetchSize(list.size());
		System.out.println(list.size());
		
		return list;
	}
	
	public Serializable delete(Commande commande) {
        session.beginTransaction();
        try { 
        	session.delete(commande);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        session.getTransaction().commit();
		return (Serializable) commande;
	}
	
	public Serializable update(Commande commande) {
        session.beginTransaction();
        try { 
        	session.update(commande);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        session.getTransaction().commit();
		return (Serializable) commande;
	}
	
	public Client getClient(Integer idClient){
		return  (Client) session.createCriteria(Client.class).add(Restrictions.eq("clientId",idClient)).uniqueResult();
	}

}
