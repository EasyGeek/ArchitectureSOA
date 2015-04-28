package com.easygeek.controller;

import org.springframework.web.bind.annotation.PathVariable;
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
	public DetailsCommande getDetails(@PathVariable Integer idCommande) {
		DetailsCommande details  = detailsService.getDetails(idCommande);
//		System.out.println("Details Commande : " + details.getCommandeId() );
		return details;
	}

}
