package com.easygeek.controller;

import com.easygeek.entite.Client;
import com.easygeek.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")

public class ClientController {

	public ClientService clientService = new ClientService();

	@RequestMapping(method = RequestMethod.GET)
	public List<Client> clients() {
		List<Client> clients = clientService.getAll();
		return clients;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Client getClient(@PathVariable Integer id) {
		Client client = clientService.get(id);
		System.out.println("getClient avec l'id : " + id);
		return client;
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public boolean connexion(@RequestBody Client c) {
		return clientService.connexion(c.getEmail(), c.getPassword());
	}

	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public ResponseEntity<Client> ajoutClient(@RequestBody Client c){
		ResponseEntity<Client> response;
		try {
			if (clientService.verifEmailNotExist(c, "ajouter"))
			{
				clientService.save(c);
				System.out.println("Ajout d'un client avec l'id :" + c.getClientId());
				response = new ResponseEntity<Client>(c, HttpStatus.OK);
			}else{
				System.out.println("Adresse mail déjà utiliser");
				response = new ResponseEntity<Client>(c, HttpStatus.METHOD_NOT_ALLOWED);
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de l'ajout du client");
			response = new ResponseEntity<Client>(c, HttpStatus.METHOD_NOT_ALLOWED);
		}
		return response;
	}

	@RequestMapping(value = "/modifier", method = RequestMethod.POST)
	public ResponseEntity<Client> modifierClient(@RequestBody Client c) {
		ResponseEntity<Client> response;
		try {
			if (clientService.verifEmailNotExist(c, "modifier"))
			{
				clientService.update(c);
				System.out.println("Modification du client avec l'id :" + c.getClientId());
				response = new ResponseEntity<Client>(c, HttpStatus.OK);
			}else{
				System.out.println("Adresse mail déjà utiliser");
				response = new ResponseEntity<Client>(c, HttpStatus.METHOD_NOT_ALLOWED);
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de la modification du client");
			response = new ResponseEntity<Client>(c, HttpStatus.METHOD_NOT_ALLOWED);
		}
		return response;
	}
	

	 /**
	 * Suppression d'un client en envoyant en DELETE le champ id
	 * http://localhost:8080/fournisseur/supprimer
	 ***/
	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.DELETE)
	public String supprimerClient(@PathVariable Integer id) {
		String message;
		
		Client client = clientService.get(id);
		
		try {
			clientService.delete(client);
			message = "Le client a été supprimé avec succés.";
			System.out.println("Client supprimer");
		} catch (Exception e) {
			message = "Le client n'a pas été supprimé car il possède encore des commandes.";
			System.out.println("Problème lors de la suppression du client");
		}
		return message;
	}
}