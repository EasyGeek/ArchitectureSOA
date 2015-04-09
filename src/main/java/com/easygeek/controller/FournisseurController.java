package com.easygeek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Fournisseur;
import com.easygeek.service.FournisseurService;

@RestController
public class FournisseurController {

	public FournisseurService fournisseurService = new FournisseurService();
	
	@RequestMapping(value = "/fournisseurs", method = RequestMethod.GET)
	public List<Fournisseur> fournisseurs() {
		List<Fournisseur> fournisseurs = fournisseurService.getAll();
		return fournisseurs;
	}
	
	@RequestMapping(value = "/fournisseur", method = RequestMethod.POST)
	public String addFournisseur(@RequestBody() String data) {
		Fournisseur f = new Fournisseur();
		System.out.println(data);
		return "Ok";
	}
}