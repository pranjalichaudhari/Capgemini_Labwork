/**
 * @author Pranjali Chaudhari
 * Desc - : Create a method that accepts a String and checks if 
 * it is a positive string. A string is considered a positive string, 
 * if on moving from left to right each character in the String comes
 *  after the previous characters in the Alphabetical order. 
 *  For Example: ANT is a positive String (Since T comes after N and N comes after A). 
 *  The method should return true if the entered string is positive.
 * 
 */
package com.cg.LabThree;
import java.util.Scanner;

public class Exercise6 {
	static boolean positiveString(String ip)
	{
		ip = ip.toUpperCase();
		int size = ip.length();
		int []arr = new int[size];
		char ch;
		for(int i = 0; i<size; i++)
		{
			ch = ip.charAt(i);
			arr[i] = ch;
		}
		for(int i = 0; i<size-1; i++)
		{
			if(arr[i]>arr[i+1])
				return false;
		}
		return true;
		
	}
	public static void main(String[] args)
	{
		String ip = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string:");
		
		ip = sc.next();
		if(positiveString(ip))
		{
			System.out.println(ip+" - It is a positive String");
		}
		else
		{
			System.out.println(ip+" - It is a not a positive String");
		}
		sc.close();
	}
}



