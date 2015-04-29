package com.easygeek.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.DetailsCommande;
import com.easygeek.service.DetailsCommandeService;

@RestController
@RequestMapping("/detailscommande")
public class DetailsCommandeController {
	
	public DetailsCommandeService detailsService = new DetailsCommandeService();
	
	@RequestMapping(value = "/{idCommande}", method = RequestMethod.GET)
	public List<DetailsCommande> getDetails(@PathVariable Integer idCommande) {
		List<DetailsCommande> details  = detailsService.getDetails(idCommande);
		

		return details;
	}
	
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public ResponseEntity<DetailsCommande> ajoutDetails(@RequestBody DetailsCommande details) {
		try {
			
			detailsService.save(details);
			System.out.println("Quantité : " +details.getQuantite());
		} catch (Exception e) {
			System.out.println("Erreur d'ajout");
		}
		return new ResponseEntity<DetailsCommande>(details, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modifier", method = RequestMethod.POST)
	public ResponseEntity<DetailsCommande> modifierDetails(@RequestBody DetailsCommande details) {
		try {
			
			detailsService.update(details);
			System.out.println("Nouvelle quantité :" +details.getQuantite());
		} catch (Exception e) {
			System.out.println("Erreur de modification");
		}
		return new ResponseEntity<DetailsCommande>(details, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.DELETE)
	public String supperimerDetails(@PathVariable Integer id) {
		String message;
		List<DetailsCommande> details = detailsService.getDetails(id);
		try {
			for (DetailsCommande detailsCommande : details) {

				detailsService.delete(detailsCommande);
			}
			message = "Le détail a été supprimé avec succés.";
		} catch (Exception e) {
			message = "Erreur de suppression";
		}
		return message;
	}
	
	

}
