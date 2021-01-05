/**
 * Display String in reverse order word by word
 * @author pranjali
 *
 */
public class Assignment1 {

	public static void main(String[] args) {
		String str1 = "Hello Dear Friend";
		//Output as  :  Friends Dear Hello
		String output = reverseString(str1);
		System.out.println(output);
		

	}

	private static String reverseString(String input) {
		String[] result=input.split(" ");
		int a =result.length-1;
		String reverse = "";
		for(int i=a;i>=0;i--)
		{
			reverse+=result[i];
			reverse+=" ";
		}
				
				
		
		return reverse;
	}

}