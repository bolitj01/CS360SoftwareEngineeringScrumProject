package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.TimeUtility;

public class TimeUtilityTest {

	@Test
	public void testHighhMs(){
	double[] array = {4,0,0};
	double result = TimeUtility.hMsToSeconds(array);
	assertEquals(14400,result,0);
		
	}
	
	@Test 
	public void testLowhMs(){
		double[] array = {0,0,1};
		double result = TimeUtility.hMsToSeconds(array);
		assertEquals(1.0,result,0);
	}
	
	@Test
	public void testNominalhMs(){
		double[]array = {2,30,12};
		double result = TimeUtility.hMsToSeconds(array);
		assertEquals(9012.0,result,0);
	}
	
	@Test
	public void testLowHours(){
		double result = TimeUtility.hours(3600);
		assertEquals(1.0,result,0);
	}
	
	@Test
	
	public void testHighHours(){
		double result = TimeUtility.hours(14400);
		assertEquals(4.0,result,0);
	}
	
	@Test
	public void nominalHoursValue(){
		double result = TimeUtility.hours(7200);
		assertEquals(2.0,result,0);
	}
	
	@Test
	public void testHighMinutes(){
		double result = TimeUtility.minutes(3540);
		assertEquals(59.0,result,0);
	}
	
	@Test
	public void testRightBelowMaxMinutes(){
		double result = TimeUtility.minutes(2400);
		assertEquals(40.0,result,0);
	}
	
	@Test 
	public void testLowMinutes(){
		double result = TimeUtility.minutes(3600);
		assertEquals(0,result,0);
	}
	@Test
	public void testRightAboveMinMinutes(){
		double result = TimeUtility.minutes(60);
		assertEquals(1.0,result,0);
	}
	
	@Test
	public void testNominalMinutes(){
		double result = TimeUtility.minutes(1500);
		assertEquals(25.0,result,0);
	}
	@Test
	public void testHighSeconds(){
		double result = TimeUtility.seconds(59);
		assertEquals(59.0,result,0);
	}
	
	@Test
	public void testRightBelowSeconds(){
		double result = TimeUtility.seconds(45);
		assertEquals(45.0,result,0);
	}
	@Test
	public void testLowSeconds(){
		double result = TimeUtility.seconds(3600);
		assertEquals(0.0,result,0);
	}
	@Test
	public void testRightAboveMinSeconds(){
		double result = TimeUtility.seconds(2);
		assertEquals(2.0,result,0);
	}
	
	@Test
	public void testParseandValidateHigh(){
		String[] array = {"4","0","0"};
		
		double[] result = TimeUtility.parseAndValidateEntries(array);
		double[] expected = {4.0,0.0,0.0};
		String resultString = "";
		String expectedString = "";
		for(int x = 0;x < expected.length;x++){
			expectedString += expected[x] + "";
		}
		for(int y = 0; y < result.length;y++){
			resultString += result[y] + "";
		}
	
		assertEquals(expectedString,resultString);
	}
	@Test
	public void testParseandValidateLow(){
		String[] array = {"0","0","1"};
		
		double[] result = TimeUtility.parseAndValidateEntries(array);
		double[] expected = {0.0,0.0,1.0};
		String resultString = "";
		String expectedString = "";
		for(int x = 0;x < expected.length;x++){
			expectedString += expected[x] + "";
		}
		for(int y = 0; y < result.length;y++){
			resultString += result[y] + "";
		}
	
		assertEquals(expectedString,resultString);
	}
	@Test
	public void testParseandValidateRightBelowMax(){
		String[] array = {"3","59","59"};
		
		double[] result = TimeUtility.parseAndValidateEntries(array);
		double[] expected = {3.0,59.0,59.0};
		String resultString = "";
		String expectedString = "";
		for(int x = 0;x < expected.length;x++){
			expectedString += expected[x] + "";
		}
		for(int y = 0; y < result.length;y++){
			resultString += result[y] + "";
		}
	
		assertEquals(expectedString,resultString);
	}
	@Test
	public void testParseandValidateRightAboveMin(){
		String[] array = {"0","0","20"};
		
		double[] result = TimeUtility.parseAndValidateEntries(array);
		double[] expected = {0.0,0.0,20.0};
		String resultString = "";
		String expectedString = "";
		for(int x = 0;x < expected.length;x++){
			expectedString += expected[x] + "";
		}
		for(int y = 0; y < result.length;y++){
			resultString += result[y] + "";
		}
	
		assertEquals(expectedString,resultString);
	}
	
	@Test
	public void testParseandValidateNominal(){
		String[] array = {"2","30","12"};
		
		double[] result = TimeUtility.parseAndValidateEntries(array);
		double[] expected = {2.0,30.0,12.0};
		String resultString = "";
		String expectedString = "";
		for(int x = 0;x < expected.length;x++){
			expectedString += expected[x] + "";
		}
		for(int y = 0; y < result.length;y++){
			resultString += result[y] + "";
		}
	
		assertEquals(expectedString,resultString);
	}
	


}


