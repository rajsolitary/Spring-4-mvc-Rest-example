package net.rajesh.spring.dao;

import java.util.Map;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 *
 */

public interface CarDao {

	public Map<String, String> getCarModelInfo(String modelName);

}
