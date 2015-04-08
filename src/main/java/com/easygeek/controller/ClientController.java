package com.easygeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Client;
import com.easygeek.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/client")
	public List<Client> clients() {
		List<Client> clients = clientService.getAll();
		return clients;
	}
}
