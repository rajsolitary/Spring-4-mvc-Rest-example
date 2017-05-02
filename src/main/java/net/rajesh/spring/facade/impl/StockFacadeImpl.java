package net.rajesh.spring.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rajesh.spring.core.buisness.logic.CurrencyType;
import net.rajesh.spring.facade.StockFacade;
import net.rajesh.spring.service.StockService;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

@Component
public class StockFacadeImpl implements StockFacade {

	@Autowired
	StockService stockService;

	@Override
	public String getStockRandPrice(String company, String stockExchangeCode, CurrencyType currencyType) {
		return stockService.getStockRandPrice(currencyType);
	}

}
