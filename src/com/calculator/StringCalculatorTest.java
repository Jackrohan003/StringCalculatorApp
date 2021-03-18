package com.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	StringCalculator cal = new StringCalculator();
	
	@Test
	public void shouldReturnZeroOnEmptyString() {
		
		assertEquals(0, cal.add(""));
	}
	@Test
	public void shouldReturnNumberOnNumber() {
		
		assertEquals(1, cal.add("1"));
	}
	@Test
	public void shouldReturnSumOfTwoNumbers() {
		
		assertEquals(3, cal.add("1,2"));
	}
	
	@Test
	public void shouldReturnSumOfMultipleNumbers() {
		
		assertEquals(10, cal.add("1,2,3,4"));
	}
	@Test
	public void shouldReturnSumOfMultipleNumbersWithNewLineDelimeter() {
		
		assertEquals(6, cal.add("1\n2,3"));
	}
	
	@Test
	public void shouldReturnSumOfMultipleNumbersWithDifferentDelimeterStartingWithDoubleSlash() {
		
		assertEquals(3, cal.add("//;\n1;2"));
	}
	
	@Test
	public void shouldRaiseExceptionOnNegativeNumbers() {
		
		try {
			cal.add("//;\n-1;-2;-3;-4");
			fail("Exception Should be generated");
		}
		catch(RuntimeException e)
		{
			System.out.println(e);
		}
		
	}
	
	@Test
	public void shouldRaiseExceptionOnNegativeNumbersAndPrintThoseNumbers() {
		
		try {
			cal.add("//;\n-1;-2;-3;4");
			fail("Exception Should be generated");
		}
		catch(RuntimeException e)
		{
			System.out.println(e);
		}
		
	}
	
	
	
	

}
