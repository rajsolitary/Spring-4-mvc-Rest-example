package net.rajesh.spring.facade.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.rajesh.spring.dao.CarDao;
import net.rajesh.spring.facade.CarFacade;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@Component
public class CarFacadeImpl implements CarFacade {

	@Autowired
	CarDao carDao;

	@Override
	public Map<String, String> getCarModelInfo(String modelName) {
		return carDao.getCarModelInfo(modelName);
	}

}
