package net.rajesh.spring.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@Component
public class EcosportCar implements Car {

	@Override
	public Map<String, String> getCarModelInfo() {

		final Map<String, String> carInfo = new LinkedHashMap<>();
		carInfo.put("EngineType", "8 pisoton engine");
		carInfo.put("EnginePower", "1311 hp");
		carInfo.put("EngineThrust", "131");
		carInfo.put("EngineRpm", "666 rpm");

		return carInfo;
	}

	@Override
	public String getType() {
		return "EcosportCar";
	}

}
