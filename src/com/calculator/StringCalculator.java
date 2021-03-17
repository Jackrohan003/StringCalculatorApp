package com.calculator;

public class StringCalculator {

	public int add(String numbers)
	{
		if(numbers==null || numbers.isEmpty())
			return 0;
		else if(numbers.contains(","))
		{
			String numbersArray[] = numbers.split(",");
			return Integer.parseInt(numbersArray[0])+Integer.parseInt(numbersArray[1]);
		}
		else
			return Integer.parseInt(numbers);
	}
}
