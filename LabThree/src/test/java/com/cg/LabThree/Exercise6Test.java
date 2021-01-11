package com.cg.LabThree;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class Exercise6Test {

	private Exercise6 exercise6;
	@Before
	public void setup() 
	{
		exercise6 = new Exercise6();
	}
	
	@Test
	public void test_PositiveString_GivenString_ShouldReurnAsString() 
	{
    
	String str="Bee";
	boolean result=  exercise6.positiveString(str);
	  assertEquals(true, result);
	}
	@Test
	public void test_PositiveString_GivenSameString_ShouldReurnAsString() 
	{
    
	String str="bbbccc";
	boolean result=  exercise6.positiveString(str);
	  assertEquals(true, result);
	}
	
	  
}

