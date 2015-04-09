package com.easygeek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Fournisseur;
import com.easygeek.service.FournisseurService;

@RestController
public class FournisseurController {

	public FournisseurService fournisseurService = new FournisseurService();
	
	@RequestMapping(value = "/fournisseurs", method = RequestMethod.GET)
	public List<Fournisseur> clients() {
		List<Fournisseur> clients = fournisseurService.getAll();
		return clients;
	}
}