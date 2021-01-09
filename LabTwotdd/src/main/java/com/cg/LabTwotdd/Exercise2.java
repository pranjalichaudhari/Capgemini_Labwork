/** 
* Name : Pranjali Chaudhari
* Desc : Create a method that can accept an array of String objects 
* and sort in alphabetical order. The elements in the left half should
*  be completely in uppercase and the elements in the right half should
*   be completely in lower case. Return the resulting array.
*/
package com.cg.LabTwotdd;

import java.util.Arrays;

public class Exercise2 {
	
	
	public String[] sortStrings(String[] string) throws Exception {
		int length = string.length;
		String result[] = new String[length];

		if(length==0)
		{
		throw new Exception("NoInputException");
		}

		else if(length==1)
		{
		result[0]=string[0].toUpperCase();
		return result;
		}

		else
		{
		Arrays.sort(string);
		for(int i =0;i<length ; i++)
		{
		if(length%2==0)
		{
		if(i<length/2)
		{
		result[i]=string[i].toUpperCase();
		   }
		   else
		result[i]=string[i].toLowerCase();
		       }
		else
		{
		if(i<length/2+1)
		{
		result[i]=string[i].toUpperCase();
		}
		else
		result[i]=string[i].toLowerCase();
		}
		}


		return result;
		}

		}
}
