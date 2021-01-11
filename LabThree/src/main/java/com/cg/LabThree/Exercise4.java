/**
 * @author Pranjali Chaudhari
 * Desc	: Create a method that accepts a number and modifies it such that the each of the digit in the newly formed number is equal to the difference between two consecutive digits in the original number. The digit in the units place can be left as it is. 
Note: Take the absolute value of the difference. Ex: 6-8 = 2

Method Name 	modifyNumber 
Method Description 	Accepts a number and modify it as per the requirement 
Argument 	int number1 
Return Type 	int 
Logic 	Accept a number and modify it such that the each of the digit in the newly formed number is equal to the difference between two consecutive digits in the original number. 
For example. 
Input: 45862 
Output:13242 
Algorithm: 
• Convert number into String 
• Extract each char using charAt method 
• Convert char to int and find the difference 
• Create new StringBuffer object and keep adding the difference 
• Finally convert StringBuffer to int 


 *
 */
package com.cg.LabThree;

public class Exercise4 {
	public static void main(String[] args) {

		int number = 45862;

		number = modifyNumber(number);
		System.out.println(number);

	}

	private static int modifyNumber(int number) {

		String num = String.valueOf(number);
		char[] previous = new char[num.length()];
		int diff = 0;
		int len = num.length();
		int digit=0;

		for (int i = 0; i < num.length(); i++) {
			previous[i] = num.charAt(i);
		}
		for (int i = 0, j = i + 1; i < num.length() && j < num.length(); i++, j++)

		{

			 digit = Math.abs(Character.getNumericValue(previous[i]) - Character.getNumericValue(previous[j]));
			

			int base = (int) Math.pow(10, len - 2);

			len--;

			
			diff = (int) (diff + (digit * base));

		}

		return diff;
	}

}
