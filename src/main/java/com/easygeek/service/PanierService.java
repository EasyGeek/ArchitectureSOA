package com.easygeek.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.easygeek.entite.Client;
import com.easygeek.entite.Commande;
import com.easygeek.entite.Composant;
import com.easygeek.util.HibernateUtil;

@Service
public class PanierService extends CoreService<Commande>{

	public PanierService() {
		super(Commande.class);
	}
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@SuppressWarnings("unchecked")
	public List<Commande> getAll() {
		return session.createCriteria(Commande.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Composant> getAllComposant() {
		return session.createCriteria(Composant.class).list();
	}
	
	/*public Commande findCommandeByClient(Integer id) {
		return (Commande) session.createCriteria(Commande.class).add(Restrictions.eq(, id)).uniqueResult();
	}*/
}
