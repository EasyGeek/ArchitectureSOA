package com.easygeek.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygeek.dao.ClientDAO;
import com.easygeek.entite.Client;
import com.easygeek.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientDAO clientDao;

	@Override
	public List<Client> getAll() {
		List<Client> clients = clientDao.getAll();
		return clients;
	}
	
}
