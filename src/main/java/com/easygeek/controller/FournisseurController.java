package com.easygeek.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	/***
	 * Affiche la liste de tous les fournisseurs
	 * http://localhost:8080/fournisseur
	 ***/
	@RequestMapping(method = RequestMethod.GET)
	public List<Fournisseur> fournisseurs() {
		List<Fournisseur> fournisseurs = fournisseurService.getAll();
		System.out.println("getAllFournisseurs");
		return fournisseurs;
	}

	/***
	 * Affiche un fournisseur en passant son id en GET au path variable :
	 * http://localhost:8080/fournisseur/id
	 ***/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Fournisseur getFournisseur(@PathVariable Integer id) {
		Fournisseur fournisseur = fournisseurService.get(id);
		System.out.println("getFournisseur avec l'id : " + id);
		return fournisseur;
	}

	/***
	 * Ajoute un fournisseur en passant un json contenant l'objet en POST
	 * http://localhost:8080/fournisseur/ajouter
	 ***/
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public ResponseEntity<Fournisseur> ajoutFournisseur(
			@RequestBody Fournisseur fournisseur) {
		try {
			fournisseurService.save(fournisseur);
			System.out.println("Le fournisseur "
					+ fournisseur.getNom() + " avec l'id "
					+ fournisseur.getFournisseurId() + " a été ajouté avec succès !");
		} catch (Exception e) {
			System.out.println("Erreur lors de l'ajout du fournisseur"
					+ fournisseur.getNom() + "avec l'id : "
					+ fournisseur.getFournisseurId());
		}
		return new ResponseEntity<Fournisseur>(fournisseur, HttpStatus.OK);
	}

	/***
	 * Modifie un fournisseur en envoyant en post les champs à modifier et en
	 * get l'id de l'utilisateur http://localhost:8080/fournisseur/modifier/{id}
	 ***/
	@RequestMapping(value = "/modifier", method = RequestMethod.POST)
	public ResponseEntity<Fournisseur> modifierFournisseur(
			@RequestBody Fournisseur fournisseur) {
		try {
			fournisseurService.update(fournisseur);
			System.out.println("Le fournisseur "
					+ fournisseur.getNom() + " avec l'id "
					+ fournisseur.getFournisseurId() + " a été modifié avec succès !");
		} catch (Exception e) {
			System.out.println("Erreur lors de la modification du fournisseur"
					+ fournisseur.getNom() + "avec l'id : "
					+ fournisseur.getFournisseurId());
		}
		return new ResponseEntity<Fournisseur>(fournisseur, HttpStatus.OK);
	}

	/***
	 * Suppression d'un fournisseur en envoyant en DELETE le champ id
	 * http://localhost:8080/fournisseur/supprimer
	 ***/
	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.DELETE)
	public String supprimerFournisseur(@PathVariable Integer id) {
		String message;
		Fournisseur fournisseur = fournisseurService.get(id);
		try {
			fournisseurService.delete(fournisseur);
			message = "Le fournisseur a été supprimé avec succés.";
			System.out.println("Le fournisseur "
					+ fournisseur.getNom() + " avec l'id "
					+ fournisseur.getFournisseurId() + " a été supprimé avec succès !");
		} catch (Exception e) {
			message = "Le fournisseur n'a pas été supprimé car il possède encore des composants.";
			System.out.println("Problème lors de la suppression du fournisseur"
					+ fournisseur.getNom() + " avec l'id : "
					+ fournisseur.getFournisseurId());
		}
		return message;
	}
}
