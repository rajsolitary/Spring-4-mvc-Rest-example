package net.rajesh.spring.core.buisness.logic;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

@Component
public class RandomRange {

	public double randomRange() {
		final Random generator = new Random();
		return generator.nextDouble();
	}

}
