package net.rajesh.spring.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@Component
public class EndeavourCar implements Car {

	@Override
	public Map<String, String> getCarModelInfo() {
		final Map<String, String> carInfo = new LinkedHashMap<>();
		carInfo.put("EngineType", "4 pisoton engine");
		carInfo.put("EnginePower", "90909 hp");
		carInfo.put("EngineThrust", "7676777");
		carInfo.put("EngineRpm", "5000 rpm");

		return carInfo;
	}

	@Override
	public String getType() {
		return "EndeavourCar";
	}

}
