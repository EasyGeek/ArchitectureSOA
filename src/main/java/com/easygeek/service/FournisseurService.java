package com.easygeek.service;

import java.util.List;

import org.hibernate.Session;

import com.easygeek.entite.Fournisseur;
import com.easygeek.util.HibernateUtil;

public class FournisseurService extends CoreService<Fournisseur>{

	public FournisseurService() {
		super(Fournisseur.class);
	}

	Session session = HibernateUtil.getSessionFactory().openSession();

	@SuppressWarnings("unchecked")
	public List<Fournisseur> getAll() {
		return session.createCriteria(Fournisseur.class).list();
	}
	
}
