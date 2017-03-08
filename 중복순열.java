
public class Solution {
	static int [] a;
	public static void main(String[] args) throws Exception{
	
		a = new int[3];
		
		//f(0, 3);
		f2(0, 3, 5);
		
	}
	// k개를 중복 사용해 k자리 숫자를 만드는 경우
	public static void f(int n, int k)
	{
		if(n==k)
		{
			for(int i=0;i<k; i++)
				System.out.print(a[i]);
			System.out.println();
		}
		else
		{
			for(int i = 1; i<=k; i++)
			{
				a[n] = i;
				f(n+1, k);
			}
		}
	}
	// m개를 중복 사용해 k자리 숫자를 만드는 경우
	public static void f2(int n, int k, int m)
	{
		if(n==k)
		{
			for(int i=0;i<k; i++)
				System.out.print(a[i]);
			System.out.println();
		}
		else
		{
			for(int i = 1; i<=m; i++)
			{
				a[n] = i;
				f2(n+1, k, m);
			}
		}
	}

}
