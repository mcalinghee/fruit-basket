package com.nuvelvision.service.component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nuvelvision.domain.Basket;
import com.nuvelvision.domain.Fruit;
import com.nuvelvision.domain.FruitType;

/**
 * Factory creating a @Basket of @Fruit
 *
 */
public class BasketFactory {

	private final static String DELIMITER = ",";
	
	private final static String INVALID_FORMAT = "Incorrect Format(line:%s) - the content should be in the following format : Lemon,2.67";
	private final static String INVALID_NUMBER = "Incorrect Number(line:%s) - please provide a decimal number";
	private final static String INVALID_FRUIT = "Incorrect Fruit(line:%s) - please provide a valid fruit : [BANANA, ORANGE, APPLE, LEMOM, PEACH]";
	
	/**
	 * Returns a @Basket of @Fruit for a given filePath
	 * 
	 */
	public static Basket createBasket(String filePath){
		if (filePath == null || filePath.isEmpty()){
			throw new IllegalArgumentException("Failed to read the file : No File was provided");			
		}
		return processFile(filePath); 	
	}

	/*
	 * Method parsing a file, extract the relevant information and build a Basket of Fruit
	 */
	private static Basket processFile(String filePath){
		List<Fruit> fruits = new ArrayList<>();
		try(Scanner fullContent = new Scanner(new FileReader(filePath))){
			int lineNumber = 0;
			// each line
			while (fullContent.hasNextLine()){
				lineNumber++;
				String line = fullContent.nextLine();
				// split the line with ','
				String[] words = line.split(DELIMITER);
				if (words.length != 2){				
					throw new IllegalArgumentException(String.format(INVALID_FORMAT,lineNumber));
				}
				// first word - fruit
				FruitType fruitType = extractFruitType(words[0],lineNumber);
				// second word - price
				Double price = extractPrice(words[1],lineNumber);
				
				Fruit fruit = new Fruit(fruitType,price);
				fruits.add(fruit);
				
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(String.format("Failed to read the file : %s",e.getMessage()));
		} 
		
		return new Basket(fruits);
	}

	private static Double extractPrice(String priceDsr, int lineNumber) {
		try{
			return Double.parseDouble(priceDsr);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(String.format(INVALID_NUMBER,lineNumber));
		}
		
	}
	
	private static FruitType extractFruitType(String description, int lineNumber){
		if (!description.isEmpty()){
			try{
				return FruitType.valueOf(description.trim().toUpperCase());
			}
			catch(Exception e) {
				throw new IllegalArgumentException(String.format(INVALID_FRUIT,lineNumber));
			}
		}
		else {
			throw new IllegalArgumentException(String.format(INVALID_FORMAT,lineNumber));
		}
	}

}
