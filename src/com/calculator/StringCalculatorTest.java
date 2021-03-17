package com.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString() {
      
		StringCalculator cal = new StringCalculator();
		assertEquals(0, cal.add(""));
	}

}
