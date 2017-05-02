package net.rajesh.spring.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import net.rajesh.spring.config.CustomGenericException;
import net.rajesh.spring.dao.CarDao;
import net.rajesh.spring.service.Car;
import net.rajesh.spring.service.factory.CarFactory;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@Component
public class CarDaoImpl implements CarDao {

	@Autowired
	CarFactory carFactory;

	@Override
	public Map<String, String> getCarModelInfo(String modelName) {
		final Car carService = carFactory.getService(modelName);
		if (carService == null)
			throw new CustomGenericException(HttpStatus.BAD_REQUEST.toString(),
					"Please check the provided parameter is correct");
		return carService.getCarModelInfo();
	}

}
