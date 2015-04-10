package com.easygeek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Client;
import com.easygeek.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

	public ClientService clientService = new ClientService();
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Client> clients() {
			List<Client> clients = clientService.getAll();
		return clients;
	}
	
	@RequestMapping(value = "ajouter", method = RequestMethod.GET)
	public String ajoutClient(@ModelAttribute("client") Client client) {
		
	String message = "Ajout effectué avec succés !";
		
		try {
			clientService.save(client);
			
			System.out.println("Ajout d'une client avec l'id :" + client.getClientId());
		} catch (Exception e) {
			message = "Problème lors de l'ajout du client";
			System.out.println("Erreur lors de l'ajout d'un client avec l'id :"
					+ client.getClientId());
			return message;
		}

		return message;
	}
}