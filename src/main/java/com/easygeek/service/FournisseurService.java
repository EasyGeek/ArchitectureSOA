package com.easygeek.service;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.easygeek.entite.Fournisseur;
import com.easygeek.entite.Stock;
import com.easygeek.util.HibernateUtil;

@Service
public class FournisseurService extends CoreService<Fournisseur>{

	public FournisseurService() {
		super(Fournisseur.class);
	}

	@SuppressWarnings("unchecked")
	public List<Fournisseur> getAll() {
		return session.createCriteria(Fournisseur.class).list();
	}
	
	public Fournisseur get(Integer id) {
		return (Fournisseur) session.createCriteria(Fournisseur.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
	
}
