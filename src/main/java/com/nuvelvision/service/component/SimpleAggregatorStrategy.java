package com.nuvelvision.service.component;

import java.util.List;

import com.nuvelvision.domain.Fruit;

/**
 * Class implementing a simple strategy that computes the total cost of a list of @Fruit
 *
 */
public class SimpleAggregatorStrategy implements AggregatorStrategy {

	@Override
	public Double computeTotalCost(List<Fruit> fruits) {
		Double total = 0d;
		for (int i = 0; i < fruits.size(); i++){
			total += fruits.get(i).getPrice();
		}
		return total;
	}

}
