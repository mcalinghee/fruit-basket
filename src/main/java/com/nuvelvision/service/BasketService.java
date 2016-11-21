package com.nuvelvision.service;

import java.util.List;

import com.nuvelvision.domain.Basket;
import com.nuvelvision.domain.Fruit;
import com.nuvelvision.service.component.AggregatorStrategy;
import com.nuvelvision.service.component.BasketFactory;
import com.nuvelvision.service.component.ForkJoinAggregatorStrategy;
import com.nuvelvision.service.component.SimpleAggregatorStrategy;

/**
 * Service that computes the total cost of a fruit basket.
 *
 */
public class BasketService {

	private static final int MAX_FRUIT_FOR_SIMPLE_STRATEGY = 10000;

	/**
	 * Computes the total cost of a fruit basket
	 * @param filePath - Path the file containing the fruit and price.
	 * @return Total Cost the fruit basket
	 * @throws Exception - The file path has to be valid and the file has to be in CSV format(FruitName,Price).
	 */
	public Double computeTotalCost(String filePath) throws Exception{
		Basket basket = createBasket(filePath);
		return computeTotalCost(basket);
		
	}
	
	private Double computeTotalCost(Basket basket){
		if ( basket == null || basket.getFruits().isEmpty() ){
			return 0d;
		}
		List<Fruit> fruits = basket.getFruits();
		
		// Choose the appropriate strategy depending the volumetry
		AggregatorStrategy strategy = null;
		if ( fruits.size() < MAX_FRUIT_FOR_SIMPLE_STRATEGY ){
			strategy = new SimpleAggregatorStrategy();
		} else{
			strategy = new ForkJoinAggregatorStrategy();
		}
		
		return strategy.computeTotalCost(fruits);
	}
	
	private Basket createBasket(String fiePath){
		return BasketFactory.createBasket(fiePath);
	}

}
