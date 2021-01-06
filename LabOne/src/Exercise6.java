
public class Exercise6 {

	static int calculateDifference(int n)
	{
		int i,sum=0,p=0,d=0,k=0;
		for(i=1;i<=n;i++)
		{
			p=p+(i*i);
		}
		for(i=1;i<=n;i++)
		{
			d=d+i;
			k=(d*d);
		}
		sum=p-k;
		return sum;
	}
	public static void main(String[] args) 
	{
		int n=5;
		int s=calculateDifference(n);
		System.out.println(s);
	}

}
