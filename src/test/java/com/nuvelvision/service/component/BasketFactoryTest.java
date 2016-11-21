package com.nuvelvision.service.component;


import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.nuvelvision.domain.Basket;
import com.nuvelvision.domain.FruitType;

public class BasketFactoryTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void createValidBasket() throws IOException{
		Basket basket = BasketFactory.createBasket(Paths.get("src/test/resources/basket.txt").toAbsolutePath().toString());
		
		Assert.assertEquals(5, basket.getFruits().size());
		Assert.assertEquals(FruitType.BANANA,basket.getFruits().get(0).getType());
		Assert.assertEquals(Double.valueOf(2.36),basket.getFruits().get(0).getPrice());
		Assert.assertEquals(FruitType.APPLE,basket.getFruits().get(1).getType());
		Assert.assertEquals(Double.valueOf(3.4),basket.getFruits().get(1).getPrice());
		Assert.assertEquals(FruitType.LEMON,basket.getFruits().get(2).getType());
		Assert.assertEquals(Double.valueOf(6.5),basket.getFruits().get(2).getPrice());
		Assert.assertEquals(FruitType.PEACH,basket.getFruits().get(3).getType());
		Assert.assertEquals(Double.valueOf(3.4),basket.getFruits().get(3).getPrice());
		Assert.assertEquals(FruitType.ORANGE,basket.getFruits().get(4).getType());
		Assert.assertEquals(Double.valueOf(2),basket.getFruits().get(4).getPrice());	
	}

	@Test
	public void loadWithNoFile() throws Exception{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Failed to read the file : No File was provided");
		BasketFactory.createBasket("");
	}

	@Test
	public void loadInvalidPriceFile() throws Exception{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Failed to read the file : Incorrect Number(line:3) - please provide a decimal number");
		BasketFactory.createBasket(Paths.get("src/test/resources/invalidPrice.txt").toAbsolutePath().toString());
	}

	@Test
	public void loadInvalidFruitFile() throws Exception{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Failed to read the file : Incorrect Fruit(line:4) - please provide a valid fruit : [BANANA, ORANGE, APPLE, LEMOM, PEACH]");
		BasketFactory.createBasket(Paths.get("src/test/resources/invalidFruit.txt").toAbsolutePath().toString());
	}
	
	@Test
	public void loadInvalidFormatFile() throws Exception{
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Failed to read the file : Incorrect Format(line:3) - the content should be in the following format : Lemon,2.67");
		BasketFactory.createBasket(Paths.get("src/test/resources/invalidFormat.txt").toAbsolutePath().toString());
	}
		
}
