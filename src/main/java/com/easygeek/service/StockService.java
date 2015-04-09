package com.easygeek.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;
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
	
	public Stock get(Integer id) {
		return (Stock) session.createCriteria(Stock.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
	
}
