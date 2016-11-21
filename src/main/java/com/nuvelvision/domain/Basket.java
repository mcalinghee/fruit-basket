package com.nuvelvision.domain;

import java.util.Collections;
import java.util.List;

/**
 * 
 * Class representing a basket of fruit(list of fruits).
 *
 */
public class Basket {
	
	private List<Fruit> fruits;
	
	public Basket(List<Fruit> fruits){
		this.fruits = fruits;
	}

	/**
	 * Returns an immutable List of fruits
	 */
	public List<Fruit> getFruits() {
		return Collections.unmodifiableList(fruits);
	}
	
	@Override
	public String toString() {
		return fruits.toString();
	}

}
