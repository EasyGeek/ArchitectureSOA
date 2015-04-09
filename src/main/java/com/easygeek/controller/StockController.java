package com.easygeek.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Stock;
import com.easygeek.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	public StockService stockService = new StockService();

	/*** Affiche la liste de tous les stocks http://localhost:8080/stock ***/
	@RequestMapping(method = RequestMethod.GET)
	public List<Stock> getAllStocks() {
		List<Stock> stocks = stockService.getAll();
		System.out.println("getAllStocks effectué");
		return stocks;
	}

	/*** Affiche un stock en passant son id dans l'URI grace
	 au path variable :  http://localhost:8080/stock/id ***/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Stock getStock(@PathVariable Integer id) {
		Stock stock = stockService.get(id);
		System.out.println("getStock effectué sur le stock id : " + id);
		return stock;
	}

	/*** Ajoute un stock en passant l'objet en modelattribute par le formulaire 
	   http://localhost:8080/stock/ajouter/quantite/reappro/reference ***/
	@RequestMapping(value = "/ajouter/{quantite}/{reapprovisionnement}/{reference}", method = RequestMethod.GET)
	public String ajoutStock(@PathVariable Integer quantite, @PathVariable Boolean reapprovisionnement, @PathVariable String reference) {
		String message = "Ajout effectué avec succés !";
		
		Stock stock = new Stock();
		stock.setQuantite(quantite);
		stock.setDate(new Date());
		stock.setReapprovisionnement(reapprovisionnement);
		stock.setReference(reference);
		
		try {
			stockService.save(stock);
			System.out.println("Ajout d'un stock avec l'id :" + stock.getId());
		} catch (Exception e) {
			message = "Problème lors de l'ajout d'un stock pour l'article référencé : "
					+ stock.getReference();
			System.out.println("Erreur lors de l'ajout d'un stock avec l'id :"
					+ stock.getId() + "et l'article référencé :"
					+ stock.getReference());
			return message;
		}

		return message;
	}

	/*** Modifie un stock en passant l'objet en modelattribute par le formulaire 
	   http://localhost:8080/stock/modifier ***/
	@RequestMapping(value = "/modifier", method = RequestMethod.PUT)
	public String modifierStock(@ModelAttribute Stock stock) {
		String message = "Modification effectuée avec succés !";

		try {
			stockService.update(stock);
			System.out.println("Modification d'un stock avec l'id :"
					+ stock.getId());
		} catch (Exception e) {
			message = "Problème lors de la modification d'un stock pour l'article référencé : "
					+ stock.getReference();
			System.out
					.println("Erreur lors de la modification d'un stock avec l'id :"
							+ stock.getId()
							+ "et l'article référencé :"
							+ stock.getReference());
			return message;
		}

		return message;
	}

	/*** Supprime un stock en passant l'objet en modelattribute par le formulaire 
	   http://localhost:8080/stock/supprimer ***/
	@RequestMapping(value = "/supprimer", method = RequestMethod.DELETE)
	public String supprimerStock(@ModelAttribute Stock stock) {
		String message = "Suppression effectuée avec succés !";

		try {
			stockService.delete(stock);
			System.out.println("Suppression d'un stock avec l'id :"
					+ stock.getId());
		} catch (Exception e) {
			message = "Problème lors de la suppression d'un stock pour l'article référencé : "
					+ stock.getReference();
			System.out
					.println("Erreur lors de la suppression d'un stock avec l'id :"
							+ stock.getId()
							+ "et l'article référencé :"
							+ stock.getReference());
			return message;
		}

		return message;
	}
}
