package com.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {

	StringCalculator cal = new StringCalculator();
	
	@Test
	@Order(1)
	public void shouldReturnZeroOnEmptyString() {
		
		assertEquals(0, cal.add(""));
	}
	@Test
	@Order(2)
	public void shouldReturnNumberOnNumber() {
		
		assertEquals(1, cal.add("1"));
	}
	@Test
	@Order(3)
	public void shouldReturnSumOfTwoNumbers() {
		
		assertEquals(3, cal.add("1,2"));
	}
	
	@Test
	@Order(4)
	public void shouldReturnSumOfMultipleNumbers() {
		
		assertEquals(10, cal.add("1,2,3,4"));
	}
	@Test
	@Order(5)
	public void shouldReturnSumOfMultipleNumbersWithNewLineDelimeter() {
		
		assertEquals(6, cal.add("1\n2,3"));
	}
	
	@Test
	@Order(6)
	public void shouldReturnSumOfMultipleNumbersWithDifferentDelimeterStartingWithDoubleSlash() {
		
		assertEquals(3, cal.add("//;\n1;2"));
	}
	
	@Test
	@Order(7)
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
	@Order(8)
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
	@Test
	@Order(9)
	public void shouldReturnSumWithoutIncludedBiggerThan1000() {
		
		assertEquals(3, cal.add("//;\n1;2;1001"));
	}
	
	@Test
	@AfterAll
	public void shouldReturnCountOfAddMethodCalled() {
		
		assertEquals(9, StringCalculator.getCalledCount());
	}
	
	
	

}
