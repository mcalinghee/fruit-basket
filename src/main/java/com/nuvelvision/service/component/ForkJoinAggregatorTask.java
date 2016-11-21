package com.nuvelvision.service.component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import com.nuvelvision.domain.Fruit;

/**
 * Class representing a task used in the Fork/Join Model implemented by the @ForkJoinAggregatorStrategy.
 *
 */
public class ForkJoinAggregatorTask extends RecursiveTask<Double> {

	private static final long serialVersionUID = -242421045467802480L;
	
	private static final int MAX_WORKLOAD = 100;
	
	private final List<Fruit> fruits;
	
	public ForkJoinAggregatorTask(List<Fruit> fruits){
		this.fruits = fruits;
	}

	@Override
	protected Double compute() {
		// if the task is small enough, do the total cost
		if ( fruits.size() <= MAX_WORKLOAD){
			return computeTotalCost();
		}

		// split the task into 2 : task 1 - small chunck/ task2 - bigger chunck(that need to be split further)
		ForkJoinAggregatorTask task1 = new ForkJoinAggregatorTask(fruits.subList(0, MAX_WORKLOAD));
		ForkJoinAggregatorTask task2 = new ForkJoinAggregatorTask(fruits.subList(MAX_WORKLOAD,fruits.size()));
		
		List<ForkJoinAggregatorTask> tasksToInvoke = new ArrayList<>();;
		tasksToInvoke.add(task1);
		tasksToInvoke.add(task2);
		
		// fork
		for (ForkJoinAggregatorTask forkJoinAggregatorTask : tasksToInvoke) {
			forkJoinAggregatorTask.fork();
		}
		
		// join the result
		Double result = 0d;
		for (ForkJoinAggregatorTask forkJoinAggregatorTask : tasksToInvoke) {
			result += forkJoinAggregatorTask.join();
		}
		
		return result;
	}

	public Double computeTotalCost() {
		Double total = 0d;
		for (int i = 0; i < fruits.size(); i++){
			total += fruits.get(i).getPrice();
		}
		return total;
	}
	
}
