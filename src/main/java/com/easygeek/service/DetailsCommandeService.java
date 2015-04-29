package com.easygeek.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.DetailsCommande;

public class DetailsCommandeService extends CoreDao<DetailsCommande> {

	public DetailsCommandeService() {
		super(DetailsCommande.class);
	}

	@SuppressWarnings("unchecked")
	public List<DetailsCommande> getDetailsCom(Integer idCommande){
		return (List<DetailsCommande>) session.createCriteria(DetailsCommande.class).add(Restrictions.eq("commande.commandeId",idCommande)).list();
				
	}
	
	@SuppressWarnings("unchecked")
	public List<DetailsCommande> getDetailsRef(String reference){
		return (List<DetailsCommande>) session.createCriteria(DetailsCommande.class).add(Restrictions.eq("composant.reference",reference)).list();
				
	}
	
	
}
