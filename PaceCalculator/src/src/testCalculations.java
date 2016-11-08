package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCalculations {

	@Test
	public void testLowTimeCalculation() {
		double result = PaceCalculatorUtility.calculateTime(1, 5);
		assertEquals(5.0,result,0);
		
	}
	
	@Test
	public void testAboveMinTime(){
		double result =  PaceCalculatorUtility.calculateTime(10, 5);
		assertEquals(50.0,result,0);
	}
	
	@Test
	public void testRightBelowMaxTime(){
		double result = PaceCalculatorUtility.calculateTime(900, 13.1094);
		assertEquals(11798.460000000001,result,0);
	}
	
	@Test
	public void nominalTimeValue(){
		double result = PaceCalculatorUtility.calculateTime(600, 5);
		assertEquals(3000.0,result,0);
	}
	
	
	@Test
	public void testHighTimeCalculation(){
		double result = PaceCalculatorUtility.calculateTime(1200, 13.1094);
		assertEquals(15731.28,result,0);
	}
	
	@Test
	public void testRightBelowMaxDistance(){
		double result = PaceCalculatorUtility.calculateDistance(20, 14400);
		assertEquals(720.0,result,0);
	}
	
	@Test
	public void testRightAboveMinDistance(){
		double result = PaceCalculatorUtility.calculateDistance(1, 20);
		assertEquals(20.0,result,0);
	}
	
	@Test
	public void nominalDistanceValue(){
		double result = PaceCalculatorUtility.calculateDistance(20, 10800);
		assertEquals(540.0,result,0);
	}
	
	@Test
	public void testHighDistanceCalculation(){
		double result = PaceCalculatorUtility.calculateDistance(1,14400);
		assertEquals(14400.0,result,0);
	}
	
	
	@Test
	public void testLowDistanceCalculation(){
		double result = PaceCalculatorUtility.calculateDistance(1,1);
		assertEquals(1.0,result,0);
	}
	
	@Test
	public void testHighPaceCalculation(){
		double result = PaceCalculatorUtility.calculatePace(1,5 );
		assertEquals(0.2,result,0);
	}
	
	@Test
	public void testRightBelowMaxPace(){
		double result = PaceCalculatorUtility.calculatePace(30, 5);
		assertEquals(6.0,result,0);
	}
	
	@Test
	public void testLowPaceCalculation(){
		double result = PaceCalculatorUtility.calculatePace(14400, 5);
		assertEquals(2880.0,result,0);
	}
	
	@Test 
	public void testRightBelowMinPace(){
		double result = PaceCalculatorUtility.calculatePace(10800, 5);
		assertEquals(2160.0,result,0);
	}
	
	@Test
	public void nominalPaceValue(){
		double result = PaceCalculatorUtility.calculatePace(7200, 5);
		assertEquals(1440.0,result,0);
	}
	
	
	
	

}
