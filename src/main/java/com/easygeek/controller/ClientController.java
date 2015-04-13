package com.easygeek.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public boolean connexion(@RequestBody String c, HttpServletRequest request) throws UnsupportedEncodingException{
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
				case "prénom":
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
	public String modifierClient(@RequestBody String c, @PathVariable Integer id){
		String message = "";
		Client client = clientService.get(id);
		
		String champs[] = c.split("&");
		for (int i = 0; i < champs.length; i++){
			String array[] = champs[i].split("=");
			switch(array[0]) {
			case "nom":
				client.setNom(array[1]);
				break;
			case "prénom":
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
			clientService.update(client);
			message = "Client modifié.";
			System.out.println("Modification du client avec l'id :" + client.getClientId());
		} catch (Exception e) {
			message = "Problème lors de la modification du client";
			System.out.println("Erreur lors de la modification du client");
		}
		return message;
	}
	
	@RequestMapping(value = "/supprimer/{id}",  method = RequestMethod.GET)
	public String supprimerClient(@PathVariable Integer id){
		String message = "";
		Client client = clientService.get(id);
		
		try {
			clientService.delete(client);
			message = "Client supprimé avec succès";
			System.out.println(message);
		} catch (Exception e) {
			message = "Problème lors de la suppression du client";
			System.out.println(message);
		}		
		return message;
	}	
}