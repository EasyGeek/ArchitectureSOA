package com.easygeek.service;

import org.hibernate.criterion.Restrictions;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.Composant;
import com.easygeek.entite.DetailsCommande;

public class DetailsCommandeService extends CoreDao<DetailsCommande> {

	public DetailsCommandeService() {
		super(DetailsCommande.class);
	}

	public DetailsCommande getDetails(Integer idCommande){
		return (DetailsCommande) session.createCriteria(DetailsCommande.class).add(Restrictions.eq("id.commandeId",idCommande)).uniqueResult();
	}
	
	public Composant getCommandeDetailsComposants(Integer idCommande){
	/*	Criteria criteria = session.createCriteria(DetailsCommande.class).add(Restrictions.eq("id.commandeId", idCommande));
		criteria.setFetchMode("Commande",FetchMode.JOIN);
		criteria.add(Restrictions.eq("commandeId", idCommande));
		
		return (DetailsCommande) criteria.uniqueResult();*/
		
		DetailsCommande Detail = (DetailsCommande) session.createCriteria(DetailsCommande.class).add(Restrictions.eq("id.commandeId",idCommande)).uniqueResult();
		
		return (Composant) session.createCriteria(Composant.class).add(Restrictions.eq("reference",Detail.getId().getReference())).uniqueResult();
		
	}
	
}
