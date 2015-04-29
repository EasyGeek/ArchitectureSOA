package com.easygeek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Composant;
import com.easygeek.entite.Marque;
import com.easygeek.entite.Type;
import com.easygeek.service.CatalogueService;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

	public CatalogueService catalogueService = new CatalogueService();

	@RequestMapping(method = RequestMethod.GET)
	public List<Composant> getAllComposants() {
		List<Composant> composants = catalogueService.getAll();
		return composants;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Composant getComposants(@PathVariable  String id) {
		Composant composants = catalogueService.getComposant(id);
		return composants;
	}
	
	@RequestMapping(value = "/type",  method = RequestMethod.GET)
	public List<Type> getAllType() {
		List<Type> types = catalogueService.getAllType();
		return types;
	}
	
	@RequestMapping(value = "/type/{id}",  method = RequestMethod.GET)
	public List<Composant> getAllComposantsByType(@PathVariable  Integer id) {
		List<Composant> composants = catalogueService.getAllComposantByType(id);
		return composants;
	}
	
	@RequestMapping(value = "/marque",  method = RequestMethod.GET)
	public List<Marque> getAllMarque() {
		List<Marque> marques = catalogueService.getAllMarque();
		return marques;
	}	
	
	@RequestMapping(value = "/marque/{id}",  method = RequestMethod.GET)
	public List<Composant> getAllComposantsByMarque(@PathVariable Integer id) {
		List<Composant> composants = catalogueService.getAllComposantByMarque(id);
		return composants;
	}	
	
	
}
