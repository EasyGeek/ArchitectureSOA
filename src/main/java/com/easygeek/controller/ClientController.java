package com.easygeek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
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
	
	/** Méthode ignoblement dégueulasse mais fonctionnelle **/
	@RequestMapping(value = "ajouter/{nom}/{prenom}/{adresse}/{codePostal}/{ville}/{telephone}/{password}/{email}", method = RequestMethod.GET)
	public String ajoutClient(@PathVariable String nom, @PathVariable String prenom, @PathVariable String adresse,@PathVariable String codePostal,@PathVariable String ville,@PathVariable String telephone,@PathVariable String password, @PathVariable String email) {
		String message = "Ajout effectué avec succés !";
		
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setCodePostal(codePostal);
		client.setVille(ville);
		client.setTelephone(telephone);
		client.setEmail(email);
		client.setPassword(password);
		
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