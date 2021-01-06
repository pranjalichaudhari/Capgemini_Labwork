
public class Exercise5 {

	static int calculateSum(int n)
	{
		int i,sum=0;
		for(i=1;i<=n;i++)
		{
			if(i%3==0 || i%5==0)
			{
				sum=sum+i;
			}
		}
		return sum;
	}

	public static void main(String[] args) 
	{
		int n=10;
		int s=calculateSum(n);
		System.out.println(s);
	}



}
