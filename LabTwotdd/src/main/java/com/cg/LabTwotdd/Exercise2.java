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
	
	
	public static String[] sortStrings(String[] str) throws Exception {
		
		int length = str.length;
		String result[] = new String[length];

		if(length==0)
		{
		throw new Exception("NoInputException");
		}
		if(length==1)
		{
			
		result[0]=str[0].toUpperCase();
		
		System.out.println(result[0]);
		
		return result;
		}

		if(length>1)
		{
			
		Arrays.sort(str);
		
		for(int i =0;i<length ; i++)
		{
		if(length%2==0 && i<length/2)
		{
			
		result[i]=str[i].toUpperCase();
		
		
		}
		   else
		   {
		result[i]=str[i].toLowerCase();
		       }		
		
		
		if(i<(length/2)+1)
		{
		result[i]=str[i].toUpperCase();
		}
		else
		result[i]=str[i].toLowerCase();
		}
		}


		return result;
		}

		}