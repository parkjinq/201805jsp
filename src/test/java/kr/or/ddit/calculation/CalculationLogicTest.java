package kr.or.ddit.calculation;

import static org.junit.Assert.*;

import org.junit.Test;

import calculation.CalculationLogic;

public class CalculationLogicTest {

	// 1 ~ 10까지의 합
	
	@Test
	public void sumBeteweenTwoNumbers() {
		CalculationLogic logic = new CalculationLogic();
		int start = 10;
		int end = 1;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(55, sumResult);
	}
	
	@Test
	public void sumBeteweenTwoNumbers2() {
		CalculationLogic logic = new CalculationLogic();
		int start = 3;
		int end = 12;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(75, sumResult);
	}

}
