package com.easygeek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easygeek.entite.Client;

@Service
public class ClientService extends CoreService<Client>{

	public ClientService() {
		super(Client.class);
	}

	@SuppressWarnings("unchecked")
	public List<Client> getAll() {
		return session.createCriteria(Client.class).list();
	}
	
}
