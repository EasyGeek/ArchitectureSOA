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
	public String ajoutFournisseur(@RequestBody String f) {
		String message = "";
		String champs[] = f.split("&");
		Fournisseur fournisseur = new Fournisseur();
		for (int i = 0; i < champs.length; i++){
			String array[] = champs[i].split("=");
			switch(array[0]) {
				case "nom":
					fournisseur.setNom(array[1]);
					break;
				case "telephone":
					fournisseur.setTelephone(array[1]);
					break;
				case "adresse":
					fournisseur.setAdresse(array[1]);
					break;
				case "codePostal":
					fournisseur.setCodePostal(array[1]);
					break;
				case "ville":
					fournisseur.setVille(array[1]);
					break;
			}   
	    }

		try {
			fournisseurService.save(fournisseur);
			message = "Fournisseur ajouter =)";
			System.out.println("Ajout d'un fournisseur avec l'id :" + fournisseur.getFournisseurId());
		} catch (Exception e) {
			message = "Problème lors de l'ajout d'un fournisseur";
			System.out.println("Erreur lors de l'ajout d'un fournisseur");
		}

		return message;
	}
	
	/*** Ajoute un stock en passant l'objet en modelattribute par le formulaire 
	   http://localhost:8080/fournisseur/modifier/{id} ***/
	@RequestMapping(value = "/modifier/{id}",  method = { RequestMethod.GET, RequestMethod.POST })
	public String modifierFournisseur(@RequestBody String f, @PathVariable Integer id) {
		String message = "";
		Fournisseur fournisseur = fournisseurService.get(id);
		
		
		String champs[] = f.split("&");
		for (int i = 0; i < champs.length; i++){
			String array[] = champs[i].split("=");
			switch(array[0]) {
				case "nom":
					fournisseur.setNom(array[1]);
					break;
				case "telephone":
					fournisseur.setTelephone(array[1]);
					break;
				case "adresse":
					fournisseur.setAdresse(array[1]);
					break;
				case "codePostal":
					fournisseur.setCodePostal(array[1]);
					break;
				case "ville":
					fournisseur.setVille(array[1]);
					break;
			}   
	    }
		
		try {
			fournisseurService.update(fournisseur);
			message = "Fournisseur modifier.";
			System.out.println("Modification du fournisseur avec l'id :" + fournisseur.getFournisseurId());
		} catch (Exception e) {
			message = "Problème lors de la modification d'un fournisseur";
			System.out.println("Erreur lors de la modification d'un fournisseur");
		}
		
		return message;
	}
	
	/*** Ajoute un stock en passant l'objet en modelattribute par le formulaire 
	   http://localhost:8080/fournisseur/supprimer/{id} ***/
	@RequestMapping(value = "/supprimer/{id}",  method = RequestMethod.GET)
	public String modifierFournisseur(@PathVariable Integer id) {
		String message = "";
		Fournisseur fournisseur = fournisseurService.get(id);
		
		try {
			fournisseurService.delete(fournisseur);
			message = "Fournisseur supprimer";
			System.out.println(message);
		} catch (Exception e) {
			message = "Problème lors de la suppression d'un fournisseur";
			System.out.println(message);
		}
		
		return message;
	}
}

