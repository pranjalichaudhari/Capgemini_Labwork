package com.cg.LabTwotdd;

/** 
* Name : Pranjali Chaudhari
* Desc : Create a method which accepts an integer array,
*  reverse the numbers in the array and returns the resulting array in sorted order
*/
import java.util.Arrays;

public class Exercise3 {

		public int sortArray(int[] numbers) {
			// TODO Auto-generated method stub
			if(numbers.length==0) {
				return 0;
			}
			else if(numbers.length>1) {
				Arrays.sort(numbers);
				return numbers[0];
			}
			return numbers[0];
			
		}

		public int sortArray1(int[] numbers) {
			// TODO Auto-generated method stub
			Arrays.sort(numbers);
			return numbers[numbers.length-1];
		}
	
}

	