package net.rajesh.spring.service;

import net.rajesh.spring.core.buisness.logic.CurrencyType;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

public interface StockService {

	String getStockRandPrice(CurrencyType currency);

}
