package com.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
 
	static int counterOfAddMethod=0;
	
	public int add(String numbers)
	{
		counterOfAddMethod++; 
		if(numbers==null || numbers.isEmpty())
			return 0;
		else if(numbers.startsWith("//"))
		{
			String  delimiter = Character.toString(numbers.charAt(2));
			if(numbers.contains("["))
				delimiter = getDelimiter(numbers);
			
			numbers = numbers.substring(numbers.indexOf("\n")+1);
			
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
	    List<Integer> negativeList = numList.stream().filter(number -> number<0).collect(Collectors.toList());
	    
	    if(negativeList.size()>0)
	    	throw new RuntimeException("Negative Not allowed"+negativeList);
	    
		int sum = numList.stream().filter(number -> number<1001).reduce(0, (num1,num2)->num1+num2);	   
		return sum;
	}
	
	public static int getCalledCount()
	{
		return counterOfAddMethod;
	}
	
	public static String getDelimiter(String s)
	{
		String opningBracket = "[";
		String closingBracket = "]";
				
	    String delimiter = s.substring(s.indexOf(opningBracket)+1, s.indexOf(closingBracket));	
		
	    if(delimiter.contains("*"))
	    {
	    	String res="";
	    	for(int i=0;i<delimiter.length();i++)
	    	{
	    		if(delimiter.charAt(i)=='*')
	    		{
	    			res+="\\*";
	    		}
	    	}
	    	delimiter=res;
	    }
	    if(s.indexOf(opningBracket)!=s.lastIndexOf(opningBracket))
	    {
	    	delimiter+="|";
	    	delimiter+=s.substring(s.lastIndexOf(opningBracket)+1, s.lastIndexOf(closingBracket));
	    }
	    
		return delimiter;
	}
	
	
}
