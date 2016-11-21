package com.nuvelvision.service.component;

import java.util.List;

import com.nuvelvision.domain.Fruit;

/**
 * Interface representing a strategy to compute a total cost of a list of fruits.
 *
 */
public interface AggregatorStrategy {
	
	Double computeTotalCost(List<Fruit> fruits);

}
