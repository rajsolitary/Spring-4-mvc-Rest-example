package net.rajesh.spring.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

@Component
public class FigoCar implements Car {

	@Override
	public Map<String, String> getCarModelInfo() {
		final Map<String, String> carInfo = new LinkedHashMap<>();
		carInfo.put("EngineType", "1 pisoton engine");
		carInfo.put("EnginePower", "3000 hp");
		carInfo.put("EngineThrust", "3000");
		carInfo.put("EngineRpm", "7878 rpm");

		return carInfo;
	}

	@Override
	public String getType() {
		return "FigoCar";
	}

}
