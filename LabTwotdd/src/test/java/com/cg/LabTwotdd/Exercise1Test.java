/** 
* Name : Pranjali Chaudhari
* Desc : Create a method which accepts an integer array,
*  reverse the numbers in the array and returns the resulting array in sorted order
*/
package com.cg.LabTwotdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cg.LabTwotdd.Exercise1;

public class Exercise1Test {
	
	private Exercise1 exercise1;
	private static int SINGLE_NUMBER=100;
	
	public void setup()
	{
		exercise1=new Exercise1();
	}
	
	@Test 
	public void test_getSecondSmallest_GivenEmptyIntegerArray_ShouldReturn0AsInteger()
	{
		int newNumbers[] = { };
		int result = Exercise1.getSecondSmallest(newNumbers);
		assertEquals(0,result);
	}
	
	public void test_getSecondSmallest_GivenTwoInteger_ShouldReturn10asInteger()
	{
		int newnumbers[] = {10,4};
		int result = Exercise1.getSecondSmallest(newnumbers);
		assertEquals(10,result);
	}
	
	public void test_getSecondSmallest_GivenWrongDatatype_ShouldReturnInvalidEntryAsString()
	{
		int newNumbers[]= {'a'};
		int result = Exercise1.getSecondSmallest(newNumbers);
		assertEquals("Invalid Entry",result);
	}

}
