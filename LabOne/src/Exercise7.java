public class Exercise7 {
	
	static boolean checkNumber(int n)
	{
		int d,r=0;
		boolean flag=false;
			while(n>0)
			{
				d=n%10;
				n=n/10;
				r=n%10;
				if(!(d>=r))
				{
					return flag;
				}
			}
			return true;			
	}

	public static void main(String[] args) 
	{
		int n=134468;
		boolean f=checkNumber(n);
		if(f)
		{
		System.out.println("It is an increasing number");
		}
		else
		{
			System.out.println("It is not an increasing number");
		}

	}


}
