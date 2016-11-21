package com.nuvelvision.startup;

import com.nuvelvision.service.BasketService;

/**
 * Main class that load a file listing the price of fruits and output the result.
 *
 */
public class Bootstrap {
	
	public static void main(String[] args) throws Exception {
			BasketService service = new BasketService();
			Double totalCost = service.computeTotalCost(args[0]);
			System.out.println("Total Cost = "+ totalCost);
	}
	
}
