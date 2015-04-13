package com.easygeek.service;

import org.springframework.stereotype.Service;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.Fournisseur;

@Service
public class FournisseurService extends CoreDao<Fournisseur>{

	public FournisseurService() {
		super(Fournisseur.class);
	}
	
}
