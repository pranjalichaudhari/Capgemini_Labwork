/**
 * 
 * @author Pranjali Chaudhari
 * Write a Java program that reads a line of integers and 
 * then displays each integer and the sum of all integers.
 *  (Use String Tokenizer class)
 */
package com.cg.LabThree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cg.LabThree.Exercise1;

public class Exercise1Test {
	
	private Exercise1 exercise1;
	private static int SINGLE_NUMBER=100;
	
	public void setup()
	{
		exercise1=new Exercise1();
	}
	
	@Test 
	public void test_sumOfIntegers_GivenEmptyInteger_ShouldReturn0AsInteger()
	{
		String newIntegers ="";
		int result = Exercise1.sumOfIntegers(newIntegers);
		assertEquals(0,result);
	}
	
	@Test 
	public void test_sumOfIntegers_GivenOneInteger_ShouldReturn1AsInteger()
	{
		String newIntegers ="1";
		int result = Exercise1.sumOfIntegers(newIntegers);
		assertEquals(1,result);
	}
	
	@Test
	public void test_sumOfInteger_GivenMoreThan1DigitInput_ShouldReturnSumAsInteger() {
		String input="8 2 5";
		int result=Exercise1.sumOfIntegers(input);
		assertEquals(15,result);
	}
	
	/*@Test 
	public void test_sumOfIntegers_GivenWrongDatatype_ShouldReturnNumberFormatExeption()
	{
		
		String newIntegers ="a";
		try {
		int result = Exercise1.sumOfIntegers(newIntegers);
		assertEquals(0, result);
		} catch (Exception e) {
		String expected= "NumberFormatException";
		assertEquals(expected,e.getMessage());
		}
		}*/
}
	
	
	
	
	

	

