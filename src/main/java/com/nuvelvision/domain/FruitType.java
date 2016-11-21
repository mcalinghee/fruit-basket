package com.nuvelvision.domain;

/**
 * Enumeration representing the type of a fruit : 
 * - Banana
 * - Orange
 * - Apple
 * - Lemon
 * - Peach
 *
 */
public enum FruitType {
	
	BANANA("Banana"), ORANGE("Orange"), APPLE("Apple"), LEMON("Lemon"), PEACH("Peach");
	
	
	private String description;
	
	private FruitType(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
		
}
