/*
 * 
 */
package net.rajesh.spring.service.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import net.rajesh.spring.config.CustomGenericException;
import net.rajesh.spring.service.Car;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@Component
public class CarFactory {

	@Autowired
	private List<Car> services;

	private static final Map<String, Car> myServiceCache = new HashMap<>();

	@PostConstruct
	public void initMyServiceCache() {
		for (final Car carService : services) {
			myServiceCache.put(carService.getType(), carService);
		}
	}

	public Car getService(String modelName) {
		final Car service = myServiceCache.get(modelName);
		if (service == null)
			throw new CustomGenericException(HttpStatus.BAD_REQUEST.toString(),
					"modelName is incorrect :{}" + modelName);
		return service;
	}

}
