package com.easygeek.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.easygeek.entite.Client;
import com.easygeek.service.ClientService;

@RestController
@RequestMapping(value = "/client")
@SessionAttributes(value = "connecter")
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
	public boolean connexion(@RequestBody String c) throws UnsupportedEncodingException{
		String email = null, password = null;
		String message = "";
		String champs[] = c.split("&");
		Client client = new Client();
		for (int i = 0; i < champs.length; i++){
			String array[] = champs[i].split("=");
			switch(array[0]) {
			case "email":
				email = array[1];
				break;
			case "password":
				password = array[1];
				break;
			}
		}
		return clientService.connexion(email, password);
	}
	
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public String ajoutClient(@RequestBody String c, @PathVariable Integer id){
		String message = "";
		String champs[] = c.split("&");
		Client client = new Client();
		for (int i = 0; i < champs.length; i++){
			String array[] = champs[i].split("=");
			switch(array[0]) {
				case "nom":
					client.setNom(array[1]);
					break;
				case "prenom":
					client.setNom(array[1]);
					break;
				case "adresse":
					client.setAdresse(array[1]);
					break;
				case "codePostal":
					client.setCodePostal(array[1]);
					break;
				case "ville":
					client.setVille(array[1]);
					break;
				case "telephone":
					client.setTelephone(array[1]);
					break;
				case "email":
					client.setEmail(array[1]);
					break;
				case "password":
					client.setPassword(array[1]);
					break;
			}   
	    }

		try {
			clientService.save(client);
			message = "Client ajouté avec succès =)";
			System.out.println("Ajout d'un fournisseur avec l'id :" + client.getClientId());
		} catch (Exception e) {
			message = "Problème lors de l'ajout du client";
			System.out.println("Erreur lors de l'ajout du client");
		}
		return message;
	}

	@RequestMapping(value = "/modifier/{id}",  method = { RequestMethod.GET, RequestMethod.POST })
	public String modifierClient(@RequestBody String c, @PathVariable Integer id) throws UnsupportedEncodingException{
		String message = "";
		Client client = clientService.get(id);
		
		String champs[] = c.split("&");
		for (int i = 0; i < champs.length; i++){
			String array[] = champs[i].split("=");
			switch(array[0]) {
			case "nom":
				client.setNom(array[1]);
				break;
			case "prenom":
				client.setNom(array[1]);
				break;
			case "adresse":
				client.setAdresse(array[1]);
				break;
			case "codePostal":
				client.setCodePostal(array[1]);
				break;
			case "ville":
				client.setVille(array[1]);
				break;
			case "telephone":
				client.setTelephone(array[1]);
				break;
			case "email":
				array[1] = new String(array[1].getBytes("iso-8859-1"), "utf8");
				client.setEmail(array[1]);
				break;
			case "password":
				client.setPassword(array[1]);
				break;
			}   
	    }
		try {
			clientService.update(client);
			message = "Client modifié.";
			System.out.println("Modification du client avec l'id :" + client.getClientId());
		} catch (Exception e) {
			message = "Problème lors de la modification du client";
			System.out.println("Erreur lors de la modification du client");
		}
		return message;
	}
	
	/*** Suppression d'un client en envoyant en DELETE le champ id 
	   http://localhost:8080/fournisseur/supprimer ***/
	@RequestMapping(value = "/supprimer",  method = RequestMethod.DELETE)
	public String supprimerClient(@RequestBody String f) {
		String message = "";
		if(!f.contains("&")) {
			String idValue[] = f.split("=");
			int id = Integer.parseInt(idValue[1]);
			
			Client client = clientService.get(id);
			
			try {
				clientService.delete(client);
				message = "Client supprimer";
				System.out.println(message);
			} catch (Exception e) {
				message = "Problème lors de la suppression du client";
				System.out.println(message);
			}
		} else {
			message = "bad argument";
		}
		
		return message;
	}
}