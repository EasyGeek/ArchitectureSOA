package com.easygeek.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.Commande;
import com.easygeek.entite.DetailsCommande;

@Service
public class PanierService extends CoreDao<Commande>{
	
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
	
	
	@SuppressWarnings("unchecked")
	public List<Commande> getCommandesClient(Integer idClient){
		return (List<Commande>) session.createCriteria(Commande.class).add(Restrictions.eq("client.clientId",idClient)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<DetailsCommande> getDetailsByCommande(Integer idCommande){
		Criteria criteria =  session.createCriteria(DetailsCommande.class).add(Restrictions.eq("id", idCommande));
		criteria.setFetchMode("Commande", FetchMode.JOIN);
		
		List<DetailsCommande> list = criteria.list();
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
	
	@SuppressWarnings("unchecked")
	public List<Commande> getAllByDate(Integer idClient){
		Criteria criteria =  session.createCriteria(Commande.class).add(Restrictions.eq("client.id", idClient)).addOrder(Order.desc("dateCommande"));
		criteria.setFetchMode("Client", FetchMode.JOIN);
		
		List<Commande> list = criteria.list();
		
		return list;
	
	}

}
