package net.rajesh.spring.resource;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.rajesh.spring.core.buisness.logic.CurrencyType;
import net.rajesh.spring.core.buisness.logic.CurrencyTypeConverter;
import net.rajesh.spring.facade.StockFacade;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

@RestController
public class StockResource {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CurrencyType.class, new CurrencyTypeConverter());
	}

	@Autowired
	StockFacade stockFacade;

	// Rest URL
	// http://localhost:8080/Spring4Rest/ford/stock?stockExchangeCode=1233&currencyType=INR
	// http://localhost:8080/Spring4Rest/ford/stock?stockExchangeCode=1233&currencyType=USD

	@RequestMapping(value = "/{company}/stock", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getRandomStockPrice(@PathVariable("company") String company,
			@RequestParam(required = false, value = "stockExchangeCode") String stockExchangeCode,
			@RequestParam(required = false, value = "currencyType") CurrencyType currencyType) {

		final String stockPrice = stockFacade.getStockRandPrice(company, stockExchangeCode, currencyType);
		if (stockPrice == null)
			return new ResponseEntity<>(stockPrice, HttpStatus.NO_CONTENT);
		final Map<String, String> price = new LinkedHashMap<>();
		price.put("Price", stockPrice);
		return new ResponseEntity<>(price, HttpStatus.OK);
	}

}
