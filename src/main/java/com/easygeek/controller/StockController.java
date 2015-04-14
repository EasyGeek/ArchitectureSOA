package com.easygeek.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
		System.out.println("getAllStocks");
		return stocks;
	}

	/*** Affiche un stock en passant son id dans l'URI grace
	 au path variable :  http://localhost:8080/stock/id ***/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Stock getStock(@PathVariable Integer id) {
		Stock stock = new Stock();
		if(id != null){
			stock = stockService.get(id);
			System.out.println("getStock effectué avec l'id : " + id);
		} else {
			System.out.println("getStock avec un id null");
		}
		return stock;
	}

	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	public ResponseEntity<Stock> ajoutStock(@RequestBody Stock stock) {
		stock.setDate(new Date());
		try {
			stockService.save(stock);
			System.out.println("Ajout d'un stock avec l'id :" + stock.getId());
		} catch (Exception e) {
			System.out.println("Erreur lors de l'ajout d'un stock avec l'id :"
					+ stock.getId() + "et l'article référencé :"
					+ stock.getReference());
			return new ResponseEntity<Stock>(new Stock(), HttpStatus.OK);
		}

		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}

	@RequestMapping(value = "/modifier", method = RequestMethod.POST )
	public ResponseEntity<Stock> modifierStock(@RequestBody Stock stock) {

		stock.setDate(new Date());
		
		try {
			stockService.update(stock);
			System.out.println("Modification d'un stock avec l'id :"
					+ stock.getId());
		} catch (Exception e) {
			System.out
					.println("Erreur lors de la modification d'un stock avec l'id :"
							+ stock.getId()
							+ "et l'article référencé :"
							+ stock.getReference());
			return new ResponseEntity<Stock>(new Stock(), HttpStatus.OK);
		}

		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}

	@RequestMapping(value = "/supprimer", method = RequestMethod.DELETE)
	public String supprimerStock(@RequestBody Stock stock) {
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
