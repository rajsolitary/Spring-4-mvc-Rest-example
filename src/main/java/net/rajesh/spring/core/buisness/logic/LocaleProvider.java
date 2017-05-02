package net.rajesh.spring.core.buisness.logic;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import net.rajesh.spring.config.CustomGenericException;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

@Component
public class LocaleProvider {

	public Locale getLocale(CurrencyType currency) {

		final Locale defaultLocale;

		switch (currency) {
		case USD:
			defaultLocale = new Locale("en", "US", "USD");
			return defaultLocale;
		case INR:
			defaultLocale = new Locale("en", "in");
			return defaultLocale;
		default:
			throw new CustomGenericException(HttpStatus.BAD_REQUEST.toString(),
					"Please check the url parameter supplied");
		}

	}

}
