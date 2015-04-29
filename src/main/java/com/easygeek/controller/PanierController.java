package com.easygeek.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Commande;
import com.easygeek.service.PanierService;

@RestController
@RequestMapping("/commande")
public class PanierController {

	public PanierService panierService = new PanierService();
	
	/*** Création d'une commande 
	   http://localhost:8080/commande/ajouter ***/
	
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public ResponseEntity<Commande> ajoutCommande(@RequestBody Commande commande) {
		try {
			commande.setDateCommande(new Date(new Date().getTime()));
			panierService.save(commande);
			System.out.println("La commande n° "
					+ commande.getCommandeId() 
					+ " a été ajoutée avec succès !");
		} catch (Exception e) {
			System.out.println("Erreur lors de l'ajout de la commande n°"
					+ commande.getCommandeId());
		}
		return new ResponseEntity<Commande>(commande, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Commande getCommande(@PathVariable Integer id) {
		Commande commande = panierService.get(id);
		System.out.println("getCommandeavec l'id : " + id);
		return commande;
	}
	
	@RequestMapping(value = "/modifier", method = RequestMethod.POST)
	public ResponseEntity<Commande> modifierCommande(@RequestBody Commande commande) {
		
		try {
			commande.setDateCommande(new Date(new Date().getTime()));
			panierService.update(commande);
			System.out.println("La commande n°  "
					+ commande.getCommandeId() +  " a été modifiée avec succès !");
		} catch (Exception e) {
			System.out.println("Erreur lors de la modification de la commande n°" 
					+ commande.getCommandeId());
		}
		return new ResponseEntity<Commande>(commande, HttpStatus.OK);
	}
	

	/***
	 * Suppression d'une commande
	 */
	@RequestMapping(value = "/supprimer",  method = RequestMethod.DELETE)
	public String supprimerCommande(@RequestBody Commande commande) {
		String message = "";
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
	
	/***
	 * Affichage des commandes par client
	 */
	@RequestMapping(value = "/client/{id}",  method = {RequestMethod.GET})
	public List<Commande> getCommandesByClient(@PathVariable Integer id){
		List<Commande> commandes = new ArrayList<Commande>();
		commandes = panierService.getCommandes(id);
		return commandes;
	}
	
	/***
	 * Historique des commandes par client
	 */
	@RequestMapping(value = "/client/{id}/historique",  method = {RequestMethod.GET})
	public List<Commande> getCommandesHistorique(@PathVariable Integer id){
		List<Commande> commandes = new ArrayList<Commande>();
		commandes = panierService.getAllByDate(id);
		return commandes;
	}

}
	
	

