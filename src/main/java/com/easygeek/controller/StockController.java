package com.easygeek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easygeek.entite.Stock;
import com.easygeek.service.StockService;

@RestController
public class StockController {
	
	public StockService stockService = new StockService();
	
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public List<Stock> stocks() {
		List<Stock> stocks = stockService.getAll();
		return stocks;
	}

}
