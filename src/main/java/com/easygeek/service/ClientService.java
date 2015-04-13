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
	
}
