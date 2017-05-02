package net.rajesh.spring.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.rajesh.spring.facade.CarFacade;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@RestController
public class CaResource {

	@Autowired
	CarFacade carFacade;

	// REst URl
	// http://localhost:8080/Spring4Rest/car/FigoCar
	// http://localhost:8080/Spring4Rest/car/EcosportCar
	// http://localhost:8080/Spring4Rest/car/EndeavourCar
	// http://localhost:8080/Spring4Rest/car/MondeoCar

	@RequestMapping(value = "/car/{modelName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<?> getCarModelInfo(@PathVariable("modelName") String modelName) {
		final Map<String, String> modelInfoMap = carFacade.getCarModelInfo(modelName);
		return new ResponseEntity<>(modelInfoMap, HttpStatus.OK);
	}

}
