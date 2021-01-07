
public class Exercise3 {


		static void getSorted(int arr[]) 
		{ 
			int n = arr.length;
			int[] b = new int[n]; 
			int j = n; 
			for (int i = 0; i < n; i++) { 
				b[j - 1] = arr[i]; 
				j = j - 1; 
			} 
			System.out.println("Reversed array is: \n"); 
			for (int k = 0; k < n; k++) { 
				System.out.println(b[k]); 
			} 
			for (int i = 0; i < b.length; i++)   
			{  
			for (int k = i + 1; k < b.length; k++)   
			{  
			int tmp = 0;  
			if (b[i] > b[k])   
			{  
			tmp = b[i];  
			b[i] = b[k];  
			b[k] = tmp;  
			}  
			}  
			}
			/*printing the reversed array*/
			System.out.println("Sorted array is: \n"); 
			for (int k = 0; k < n; k++) { 
				System.out.println(b[k]); 
			} 
			
		} 

		public static void main(String[] args) 
		{ 
			int [] arr = {40, 20, 50, 10, 30}; 
			getSorted(arr); 
		} 
	} 


