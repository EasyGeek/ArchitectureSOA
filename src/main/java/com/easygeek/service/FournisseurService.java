package com.easygeek.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.easygeek.entite.Fournisseur;
import com.easygeek.util.HibernateUtil;

@Service
public class FournisseurService extends CoreService<Fournisseur>{

	public FournisseurService() {
		super(Fournisseur.class);
	}

	Session session = HibernateUtil.getSessionFactory().openSession();

	@SuppressWarnings("unchecked")
	public List<Fournisseur> getAll() {
		return session.createCriteria(Fournisseur.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public Integer addFournisseur(Fournisseur f) {
		session.beginTransaction();
		session.save(f);
		session.getTransaction().commit();
		return f.getFournisseurId();
	}
	
}
