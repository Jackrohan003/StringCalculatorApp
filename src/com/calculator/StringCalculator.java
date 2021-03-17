package com.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	public int add(String numbers)
	{
		if(numbers==null || numbers.isEmpty())
			return 0;
		else if(numbers.startsWith("//"))
		{
			String  delimiter = Character.toString(numbers.charAt(2));
			numbers = numbers.substring(4);
			
			return getSumWithDelimeter(numbers,delimiter);
		}
		else if(numbers.contains(",") || numbers.contains("\\n") )
			return getSumWithDelimeter(numbers,",");
		else
			return Integer.parseInt(numbers);
	}
	public int getSumWithDelimeter(String numbers,String delimiter)
	{
		List<Integer> numList = Arrays.stream(numbers.split(delimiter+"|\\n")).map(Integer::parseInt).collect(Collectors.toList());
	    int sum = numList.stream().reduce(0, (num1,num2)->num1+num2);
		
		return sum;
	}
	
	
}
