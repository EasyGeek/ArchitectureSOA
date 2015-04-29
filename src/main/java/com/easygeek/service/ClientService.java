package com.easygeek.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.Client;

@Service
public class ClientService extends CoreDao<Client> {

	public ClientService() {
		super(Client.class);
	}

	@SuppressWarnings("unchecked")
	public boolean connexion(String email, String password) {
		Criteria query = session.createCriteria(Client.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password));
	
		List<Client> clients = query.list();
	
		if (clients.size() > 0)
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("unchecked")
	public Boolean verifEmailNotExist(Client client, String action) {
		Criteria query = session.createCriteria(Client.class)
				.add(Restrictions.eq("email", client.getEmail()));
		if (action == "modifier")
		{
			query.add(Restrictions.not(Restrictions.eq("clientId", client.getClientId())));
		}
		List<Client> clients = query.list();
	
		if (clients.size() > 0)
			return false;
		else
			return true;
	}
}