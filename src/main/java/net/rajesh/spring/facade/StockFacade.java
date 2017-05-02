package net.rajesh.spring.facade;

import net.rajesh.spring.core.buisness.logic.CurrencyType;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */
public interface StockFacade {

	String getStockRandPrice(String company, String stockExchangeCode, CurrencyType currency);

}
