package com.easygeek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Fournisseur;
import com.easygeek.service.FournisseurService;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {

	public FournisseurService fournisseurService = new FournisseurService();
	
	/*** Affiche la liste de tous les fournisseurs
	 * http://localhost:8080/fournisseur ***/
	@RequestMapping(method = RequestMethod.GET)
	public List<Fournisseur> fournisseurs() {
		List<Fournisseur> fournisseurs = fournisseurService.getAll();
		return fournisseurs;
	}
	
	/*** Affiche un fournisseur en passant son id en GET
	 * au path variable :  http://localhost:8080/fournisseur/id ***/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Fournisseur getFournisseur(@PathVariable Integer id) {
		Fournisseur fournisseur = fournisseurService.get(id);
		System.out.println("getFourniseur avec l'id : " + id);
		return fournisseur;
	}
	
	/*** Ajoute un fournisseur en passant en POST les champs à renseigner
	 * http://localhost:8080/fournisseur/ajouter ***/
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
			System.out.println(message);
		}

		return message;
	}
	
	/*** Modifie un fournisseur en envoyant en post les champs à modifier et en get l'id de l'utilisateur 
	 * http://localhost:8080/fournisseur/modifier/{id} ***/
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
			message = "Modification du fournisseur avec l'id :" + fournisseur.getFournisseurId();
			System.out.println(message);
		} catch (Exception e) {
			message = "Problème lors de la modification d'un fournisseur";
			System.out.println(message);
		}
		
		return message;
	}
	
	/*** Suppression d'un fournisseur en envoyant en DELETE le champ id 
	   http://localhost:8080/fournisseur/supprimer ***/
	@RequestMapping(value = "/supprimer",  method = RequestMethod.DELETE)
	public String supprimerFournisseur(@RequestBody String f) {
		String message = "";
		if(!f.contains("&")) {
			String idValue[] = f.split("=");
			int id = Integer.parseInt(idValue[1]);
			
			Fournisseur fournisseur = fournisseurService.get(id);
			
			try {
				fournisseurService.delete(fournisseur);
				message = "Fournisseur supprimer";
				System.out.println(message);
			} catch (Exception e) {
				message = "Problème lors de la suppression d'un fournisseur";
				System.out.println(message);
			}
		} else {
			message = "bad argument";
		}
		
		return message;
	}
}

