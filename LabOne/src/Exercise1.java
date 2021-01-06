import java.util.Scanner;
public class Exercise1{
	
	private static void SumOfCube(int n) {
		int sum=0,temp;
		while(n!=0)
		{
		temp = n%10;
		sum = sum +(temp*temp*temp);
		n = n/10;

		}
		System.out.println(sum);
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = sc.nextInt();
		SumOfCube(num);
		sc.close();
	}

}
