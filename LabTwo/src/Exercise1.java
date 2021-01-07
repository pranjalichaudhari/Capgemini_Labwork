public class Exercise1 {
	
	private static void getSecondSmallest(int[] array) {
		// TODO Auto-generated method stub
		
		int temp,size;
		size = array.length;
		
		for(int i = 0; i<size; i++ ){
	         for(int j = i+1; j<size; j++){
	            if(array[i]>array[j]){
	               temp = array[i];
	               array[i] = array[j];
	               array[j] = temp;
	            }
	         }
	      }
		
	      System.out.println("2nd Smallest element of the array is:"+array[1]);
	}
	public static void main(String[] args)   
	{  
	 
	int[] array = {10, 4, 0, 2, 7, -3};
	
	
	getSecondSmallest(array);
	
	
	
	}
}

	
