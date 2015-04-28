package com.easygeek.service;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.DetailsCommande;

public class DetailsCommandeService extends CoreDao<DetailsCommande> {

	public DetailsCommandeService() {
		super(DetailsCommande.class);
	}
	
	@SuppressWarnings("unchecked")
	public DetailsCommande getDetails(Integer idCommande){
		
	return (DetailsCommande) session.createCriteria(DetailsCommande.class).add(Restrictions.eq("commandeId", idCommande))
			.setFetchMode("details_commande", FetchMode.JOIN)
			.uniqueResult();
	
	} 


}
