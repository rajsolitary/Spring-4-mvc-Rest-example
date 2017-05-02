package net.rajesh.spring.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@Component
public class MondeoCar implements Car {

	@Override
	public Map<String, String> getCarModelInfo() {

		final Map<String, String> carInfo = new LinkedHashMap<>();
		carInfo.put("EngineType", "3 pisoton engine");
		carInfo.put("EnginePower", "123322 hp");
		carInfo.put("EngineThrust", "2000022");
		carInfo.put("EngineRpm", "2000 rpm");

		return carInfo;
	}

	@Override
	public String getType() {
		return "MondeoCar";
	}

}
