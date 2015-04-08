package com.easygeek.dao;

import java.util.List;

import com.easygeek.entite.Client;

public class ClientDAO extends CoreDAO<Client>{
    
	public ClientDAO() {
		super(Client.class);
	}

	@SuppressWarnings("unchecked")
	public List<Client> getAll(){
		return session.createCriteria(Client.class).list();
	}
	
}
