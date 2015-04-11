package com.easygeek.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.stereotype.Service;

import com.easygeek.entite.Client;
import com.easygeek.entite.Commande;

@Service
public class ClientService extends CoreService<Client>{
	
	public ClientService() {
		super(Client.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Commande> getCommandes(Integer idClient){
		Criteria criteria =  session.createCriteria(Commande.class);
		criteria.setFetchMode("Client", FetchMode.JOIN);
		List<Commande> list = criteria.list();
		System.out.println(list);
		return list;
	}
	
}
