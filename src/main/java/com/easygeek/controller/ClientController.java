package com.easygeek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Client;
import com.easygeek.service.ClientService;

@RestController
public class ClientController {

	public ClientService clientService = new ClientService();
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public List<Client> clients() {
			List<Client> clients = clientService.getAll();
		return clients;
	}
}