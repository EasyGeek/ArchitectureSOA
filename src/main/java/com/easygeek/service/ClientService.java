package com.easygeek.service;

import org.springframework.stereotype.Service;

import com.easygeek.entite.Client;

@Service
public class ClientService extends CoreService<Client>{

	public ClientService() {
		super(Client.class);
	}
	
}
