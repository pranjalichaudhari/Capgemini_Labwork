/** 
* Name : Pranjali Chaudhari
* Desc : Create a method which accepts an integer array
*  and removes all the duplicates in the array. 
*  Return the resulting array in descending order
*  NOTE : Not done in TDD form
*/
package com.cg.LabTwotdd;

import java.util.Scanner;
public class Exercise4 {
	public static int modifyArray(int array[]){
		int n = array.length;
		if(n==0 || n==1){
		return n;
		}
		int j = 0,k=0;//for next element
		for (int i=0; i < n-1; i++){
		if (array[i] != array[i+1]){
		array[j++] = array[i];
		}
		}
		array[j++] = array[n-1];
		
		for (int i = 0; i < array.length; i++) {     
            for ( k = i+1; k < array.length; k++) {     
               if(array[i] < array[k]) {    
                   int temp = array[i];    
                   array[i] = array[k];    
                   array[k] = temp;    
               }     
            }     
        }    
		
		return k;
		}
		public static void main (String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the number of elements you want to store: ");  
			//reading the number of elements from the that we want to enter  
			int n=sc.nextInt();  
			//creates an array in the memory of length 10  
			int[] array = new int[10];  
			System.out.println("Enter the elements of the array: ");  
			for(int i=0; i<n; i++)  
			{  
			//reading array elements from the user   
			array[i]=sc.nextInt();  
			}  
		//int array[] = {18,18,25,25,25,28,28,29};
		
		int length = modifyArray(array);
		for(int i=0; i<length; i++)
		System.out.print(array[i]+" ");
		sc.close();
		}
}

