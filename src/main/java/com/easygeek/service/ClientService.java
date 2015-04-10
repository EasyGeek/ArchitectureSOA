package com.easygeek.service;

import org.springframework.stereotype.Service;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.Client;

@Service
public class ClientService extends CoreDao<Client>{

	public ClientService() {
		super(Client.class);
	}
	
}
