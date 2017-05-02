package net.rajesh.spring.service.impl;

import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import net.rajesh.spring.config.CustomGenericException;
import net.rajesh.spring.core.buisness.logic.CurrencyType;
import net.rajesh.spring.core.buisness.logic.LocaleProvider;
import net.rajesh.spring.core.buisness.logic.RandomRange;
import net.rajesh.spring.service.StockService;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

@Component
public class StockServiceImpl implements StockService {

	@Autowired
	RandomRange randomRange;

	@Autowired
	LocaleProvider localeProvider;

	@Override
	public String getStockRandPrice(CurrencyType currencyType) {
		// set default to USD
		if (currencyType == null)
			currencyType = CurrencyType.USD;

		final double randomPrice;
		final NumberFormat currencyFormat;
		final String currencyValue;

		switch (currencyType) {
		case USD:
			randomPrice = randomRange.randomRange();
			currencyFormat = NumberFormat.getCurrencyInstance(localeProvider.getLocale(currencyType));
			currencyValue = currencyFormat.format(randomPrice);
			return currencyValue;
		case INR:
			randomPrice = randomRange.randomRange();
			currencyFormat = NumberFormat.getCurrencyInstance(localeProvider.getLocale(currencyType));
			currencyValue = currencyFormat.format(randomPrice);
			return currencyValue;

		default:
			throw new CustomGenericException(HttpStatus.BAD_REQUEST.toString(),
					"Please check the url parameter supplied");
		}

	}
}
