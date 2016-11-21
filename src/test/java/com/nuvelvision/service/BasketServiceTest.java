package com.nuvelvision.service;


import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BasketServiceTest {
	
	private BasketService service = new BasketService();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void loadWithIncorrectFilePath() throws Exception{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Failed to read the file : \\basket.txt (No such file or directory)");
		service.computeTotalCost("\\basket.txt");
	}

	@Test
	public void computeTotalCostFromFile() throws Exception{
		Double total = service.computeTotalCost(Paths.get("src/test/resources/basket.txt").toAbsolutePath().toString());
		Assert.assertEquals(Double.valueOf(17.66), total);
	}
	
}
