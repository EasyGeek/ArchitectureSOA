package com.easygeek.service;

import org.springframework.stereotype.Service;

import com.easygeek.dao.CoreDao;
import com.easygeek.entite.Stock;

@Service
public class StockService extends CoreDao<Stock>{

	public StockService() {
		super(Stock.class);
	}
	
}
