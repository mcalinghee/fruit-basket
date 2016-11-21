package com.nuvelvision.service.component;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.nuvelvision.domain.Fruit;
import com.nuvelvision.domain.FruitType;

public class ForkJoinAggregatorStrategyTest {
	
	private ForkJoinAggregatorStrategy strategy = new ForkJoinAggregatorStrategy();
		@Test
	public void computeTotalCostWithSimpleAggregator(){
		
		List<Fruit> fruits = new ArrayList<>();
		fruits.add(new Fruit(FruitType.APPLE,2.35d));
		fruits.add(new Fruit(FruitType.PEACH,4.78d));
		fruits.add(new Fruit(FruitType.ORANGE,2.89d));
		fruits.add(new Fruit(FruitType.BANANA,3.99d));
		fruits.add(new Fruit(FruitType.LEMON,2.9d));
		fruits.add(new Fruit(FruitType.PEACH,1.2d));
		Double total = strategy.computeTotalCost(fruits);
		Assert.assertEquals(Double.valueOf(18.11), total);
	}
	
}
