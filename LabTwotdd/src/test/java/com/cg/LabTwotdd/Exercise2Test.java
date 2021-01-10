/** 
* Name : Pranjali Chaudhari
* Desc : Create a method that can accept an array of String objects 
* and sort in alphabetical order. The elements in the left half should
*  be completely in uppercase and the elements in the right half should
*   be completely in lower case. Return the resulting array.
*/
package com.cg.LabTwotdd;
import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise2Test {
	Exercise2 object = new Exercise2();
	String [] input = {"coffee","tea","latte","americano"};

	@Test
	public void TestSortStrings_GivenNoInput_ShouldReturnNoInputException() {
	String [] input = {};
	try {
	String [] result = object.sortStrings(input);
	assertEquals(0, result);
	} catch (Exception e) {
	String expected= "NoInputException";
	assertEquals(expected,e.getMessage());
	}

	}

	@Test
	public void TestSortStrings_Given1StringAsInput_ShouldReturn1StringInUpperCase() {
	String [] input = {"cappuchino"};
	try {
	String [] result = object.sortStrings(input);
	assertEquals("CAPPUCHINO", result[0]);
	}  catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}

	@Test
	public void TestSortStrings_GivenAnyNumberOfStringAsInput_ShouldReturnHalfStringsInUpperCaseAndOtherInLowerCase()
	{
	try {
	String [] result =object.sortStrings(input);
	String[] expected = {"AMERICANO", "COFFEE", "LATTE", "tea"};
	assertArrayEquals(expected, result);
	} catch (Exception e) {
	e.printStackTrace();
	}
	}

}
