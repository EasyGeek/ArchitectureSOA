package com.easygeek.controller;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Fournisseur;
import com.easygeek.entite.Stock;
import com.easygeek.service.FournisseurService;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {

	public FournisseurService fournisseurService = new FournisseurService();
	
	/*** Affiche la liste de tous les stocks http://localhost:8080/fournisseur ***/
	@RequestMapping(method = RequestMethod.GET)
	public List<Fournisseur> fournisseurs() {
		List<Fournisseur> fournisseurs = fournisseurService.getAll();
		return fournisseurs;
	}
	
	/*** Affiche un stock en passant son id dans l'URI grace
	 au path variable :  http://localhost:8080/fournisseur/id ***/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Fournisseur getFournisseur(@PathVariable Integer id) {
		Fournisseur fournisseur = fournisseurService.get(id);
		System.out.println("fournisseur effectué sur le stock id : " + id);
		return fournisseur;
	}
	
	/*** Ajoute un stock en passant l'objet en modelattribute par le formulaire 
	   http://localhost:8080/fournisseur/ajouter ***/
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public String ajoutFournisseur(@ModelAttribute Fournisseur fournisseur) {
		String message = "Ajout effectué avec succés !";

		try {
			fournisseurService.save(fournisseur);
			fournisseurService.commit();
			
			System.out.println("Ajout d'un fournisseur avec l'id :" + fournisseur.getFournisseurId());
		} catch (Exception e) {
			message = "Problème lors de l'ajout d'un fournisseur";
			System.out.println("Erreur lors de l'ajout d'un fournisseur");
			return message;
		}

		return message;
	}
}

