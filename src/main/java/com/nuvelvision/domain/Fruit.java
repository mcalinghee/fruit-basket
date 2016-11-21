package com.nuvelvision.domain;

/**
 * Class representing a Fruit.
 * 
 * A fruit is defined by a @FruitType and a Price. 
 *
 */
public class Fruit {
	
	private final FruitType type;
	
	private final Double price;
	
	public Fruit(FruitType type, Double price){
		this.type = type;
		this.price = price;
	}
	
	/**
	 * Returns the type of the fruit
	 */
	public FruitType getType() {
		return type;
	}
	
	/**
	 * Returns the price of the fruit
	 */
	public Double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("Fruit[type=%s,price=%s]",type,price);
	}
	
}
