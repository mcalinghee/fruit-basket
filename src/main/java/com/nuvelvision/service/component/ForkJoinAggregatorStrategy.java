package com.nuvelvision.service.component;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import com.nuvelvision.domain.Fruit;

/**
 * Class implementing a strategy that computes the total cost of a list of @Fruit by using a Fork Join model.
 * This class is intend to be used for big volume of data.
 *
 */
public class ForkJoinAggregatorStrategy implements AggregatorStrategy {

	@Override
	public Double computeTotalCost(List<Fruit> fruits) {
 		ForkJoinPool pool = new ForkJoinPool();
 		ForkJoinAggregatorTask task = new ForkJoinAggregatorTask(fruits);
		return pool.invoke(task);
	}

}
