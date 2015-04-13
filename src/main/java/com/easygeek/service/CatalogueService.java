package com.easygeek.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.Client;
import com.easygeek.entite.Composant;

@Service
public class CatalogueService extends CoreDao<Composant>{

	public CatalogueService() {
		super(Composant.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Composant> getAllComposantByMarque(Integer idMarque){
		return session.createCriteria(Composant.class).add(Restrictions.eq("marqueId",idMarque)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Composant> getAllComposantByType(Integer idType){
		return session.createCriteria(Composant.class).add(Restrictions.eq("typeId",idType)).list();
	}
}
