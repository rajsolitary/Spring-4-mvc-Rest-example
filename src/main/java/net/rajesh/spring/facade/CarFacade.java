package net.rajesh.spring.facade;

import java.util.Map;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

public interface CarFacade {

	public Map<String, String> getCarModelInfo(String modelName);
}
