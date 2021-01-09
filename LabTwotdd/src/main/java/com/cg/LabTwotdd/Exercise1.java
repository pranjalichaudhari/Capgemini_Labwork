/** 
* Name : Pranjali Chaudhari
* Desc : Create a method which accepts an array of 
* integer elements and return the second smallest element in the array
*/

package com.cg.LabTwotdd;

public class Exercise1 {
	public static int getSecondSmallest(int[] array) {
		// TODO Auto-generated method stub
		
		int temp,size;
		size = array.length;
		if(array.length==0)
		{
			return 0;
		}
		for(int i = 0; i<size; i++ ){
	         for(int j = i+1; j<size; j++){
	            if(array[i]>array[j]){
	               temp = array[i];
	               array[i] = array[j];
	               array[j] = temp;
	            }
	         }
	      }
		
		return array[1];
	     // System.out.println("2nd Smallest element of the array is:"+array[1]);
	}
	public static void main(String[] args)   
	{  
	 
	int[] array = {10, 4, 0, 2, 7};
	
	
	int res = getSecondSmallest(array);
	System.out.println("2nd Smallest element of the array is:"+res);
	
	
	
	}
}
