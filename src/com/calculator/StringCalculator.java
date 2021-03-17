package com.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	public int add(String numbers)
	{
		if(numbers==null || numbers.isEmpty())
			return 0;
		else if(numbers.contains(","))
		{
			List<Integer> numList = Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
		    int sum = numList.stream().reduce(0, (num1,num2)->num1+num2);
			
			return sum;
		}
		else
			return Integer.parseInt(numbers);
	}
}
