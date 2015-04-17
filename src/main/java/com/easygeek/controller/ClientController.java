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
	public ResponseEntity ajoutClient(@RequestBody Client c){
		try {
			if (clientService.verifEmailNotExist(c.getEmail(), "ajouter"))
			{
				clientService.save(c);
				System.out.println("Ajout d'un fournisseur avec l'id :" + c.getClientId());
			}else{
				System.out.println("fuck of");
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de l'ajout du client");
		}
		return new ResponseEntity<Client>(c, HttpStatus.OK);
	}

	@RequestMapping(value = "/modifier", method = RequestMethod.POST)
	public ResponseEntity modifierClient(@RequestBody Client c) {
		try {
			if (clientService.verifEmailNotExist(c.getEmail(), "modifier"))
			{
				clientService.update(c);
				System.out.println("Modification du client avec l'id :" + c.getClientId());
			}else{
				System.out.println("fuck of");
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de la modification du client");
		}
		return new ResponseEntity<Client>(c, HttpStatus.OK);
	}
	

	 /**
	 * Suppression d'un client en envoyant en DELETE le champ id
	 * http://localhost:8080/fournisseur/supprimer
	 ***/
	@RequestMapping(value = "/supprimer", method = RequestMethod.DELETE)
	public String supprimerClient(@RequestBody Client c) {
		String message;
		try {
			clientService.delete(c);
			message = "Success";
			System.out.println("Client supprimer");
		} catch (Exception e) {
			message = "Failed";
			System.out.println("Problème lors de la suppression du client");
		}
		return message;
	}
}