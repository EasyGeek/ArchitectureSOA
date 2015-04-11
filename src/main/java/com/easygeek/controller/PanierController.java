package com.easygeek.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Client;
import com.easygeek.entite.Commande;
import com.easygeek.entite.Composant;
import com.easygeek.entite.Fournisseur;
import com.easygeek.service.ClientService;
import com.easygeek.service.PanierService;

@RestController
@RequestMapping("/commande")
public class PanierController {
/** TODO :
 * - Affichage commandes par client(id)
 * - Ajout commande quantité, réf, + prix HT pour chaque (?)
 */
	public PanierService panierService = new PanierService();
	public ClientService clientService = new ClientService();
	
	/*@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Commande getCommande(@PathVariable Integer id) {
		Commande commande = clientService.findCommandeByClient(id);
		System.out.println("ID client :  " + id);
		return commande;
	}*/

	/*** Création d'une commande 
	   http://localhost:8080/panier/ajouter ***/
	
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST	)
	public String creerCommande(@RequestBody String c) {
		String message = "";
		String champs[] = c.split("&");
		Commande commande = new Commande();
		try{
			for (int i = 0; i < champs.length; i++){
				String array[] = champs[i].split("=");
				switch(array[0]) {
					case "date":
						commande.setDateCommande(new Date());
						break;
					case "prixHT":
						commande.setPrixHt(Double.parseDouble(array[0]));
						break;
					case "client":
						commande.setClient(new Client());
						break;
					case "typeLivraison":
						commande.setTypeLivraisonId(Integer.parseInt(array[0]));
						break;
				}  
			}
		} catch(Exception e) {
			message = "Erreur";
		}
			try {
				panierService.save(commande);
				message = "Commande créée avec succès !";
				System.out.println("ID Commande :" + commande.getCommandeId());
			} catch (Exception e) {
				message = "Erreur lors de la création de la commander";
				System.out.println("Erreur lors de la création de la commander");
			}

			return message;
		}
	/***
	 * Modification d'une commande
	 */
	@RequestMapping(value = "/modifier/{id}",  method = { RequestMethod.GET, RequestMethod.POST })
	public String modifierCommande(@RequestBody String f, @PathVariable Integer id) {
		String message = "";
		Commande commande = panierService.get(id);
		String champs[] = f.split("&");
		
		try{
			for (int i = 0; i < champs.length; i++){
				String array[] = champs[i].split("=");
				switch(array[0]) {
					case "date":
						commande.setDateCommande(new Date());
						break;
					case "prixHT":
						commande.setPrixHt(Double.parseDouble(array[0]));
						break;
					case "client":
						commande.setClient(new Client());
						break;
					case "typeLivraison":
						commande.setTypeLivraisonId(Integer.parseInt(array[0]));
						break;
				}  
			}
		} catch(Exception e) {
			message = "Erreur";
		}
			try {
				panierService.update(commande);
				message = "Commande modifiée avec succès !";
				System.out.println("ID Commande :" + commande.getCommandeId());
			} catch (Exception e) {
				message = "Problème lors de la modification";
				System.out.println("Erreur de modification");
			}

			return message;
		}

	/***
	 * Suppression d'une commande
	 */
	@RequestMapping(value = "/supprimer/{id}",  method = RequestMethod.GET)
	public String supprimerCommande(@PathVariable Integer id) {
		String message = "";
		Commande commande = panierService.get(id);
		
		try {
			panierService.delete(commande);
			message = "Commande supprimée avec succès";
			System.out.println(message);
		} catch (Exception e) {
			message = "Erreur de suppression";
			System.out.println(message);
		}
		
		return message;
	}
	
	/*** Affichage du panier 
	 http://localhost:8080/panier/
	 ***/
	@RequestMapping(method = RequestMethod.GET)
	 public List<Composant> getPanier() {
	  List<Composant> commandes = panierService.getAllComposant();
	  System.out.println("getPaniereffectué");
	  return commandes;
	 }
	
	/***
	 * Affichae des commandes par client
	 */
	/*@RequestMapping(value = "/client/{id}",  method = {RequestMethod.GET})
	public Commande getCommandesByClient(@PathVariable Integer id){
		List<Commande> commandes = new ArrayList<Commande>();
		commandes = clientService.getCommandes(id);
		System.out.println(commandes.size());
	

		return commandes.get(0);
	}*/
}
	
	

