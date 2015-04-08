package com.easygeek.service;

import java.util.List;

import org.hibernate.Session;

import com.easygeek.entite.Client;
import com.easygeek.service.ClientService;
import com.easygeek.util.HibernateUtil;

public class ClientService extends CoreService<Client>{

	public ClientService() {
		super(Client.class);
	}

	Session session = HibernateUtil.getSessionFactory().openSession();

	@SuppressWarnings("unchecked")
	public List<Client> getAll() {
		return session.createCriteria(Client.class).list();
	}
	
}
