package com.easygeek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easygeek.entite.Stock;

@Service
public class StockService extends CoreService<Stock>{

	public StockService() {
		super(Stock.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> getAll() {
		return session.createCriteria(Stock.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> get() {
		return session.createCriteria(Stock.class).list();
	}
}
