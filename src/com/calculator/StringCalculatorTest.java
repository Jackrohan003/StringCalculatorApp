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
	

}
