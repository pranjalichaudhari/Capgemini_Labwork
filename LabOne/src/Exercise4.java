import java.util.Scanner;
public class Exercise4 {

	private static void Prime(int number)
	{
		int flag =0;
		if(number==2)
			System.out.println(number);
		else {
		for(int i =2; i<=number/2;i++)
		{
			if(number%i==0)
				flag=1;
			
		}
		if(flag ==0)
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int num = sc.nextInt();
		for (int i =2;i<=num;i++)
		{
			Prime(i);
		}
		sc.close();

	}

}
