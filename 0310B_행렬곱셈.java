import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [] p;

	
	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			int N = sc.nextInt();
			int result = 1;
			p = new int[N+1];
			p[0]=sc.nextInt();
			p[1]=sc.nextInt();
			
			for(int i = 1; i<N; i++)
			{
				int r = sc.nextInt();
				int c = sc.nextInt();
				if(p[i]!=r)
					result = 0;
				p[i] = r;
				p[i+1] = c;
			}
			if(result != 0)
				result = find(N);
			System.out.println("#"+tc+" "+result);
		}
		
	}
	public static int find(int n)
	{
		int [][] m = new int[n+1][n+1];
		for(int l = 1; l<n; l++)
		{
			for(int i = 1; i<=n-l; i++)
			{
				int j = i+l;
				int min = Integer.MAX_VALUE;
				for(int k = i; k<j; k++)
				{
					int cnt = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(min>cnt)
						min = cnt;
				}
				m[i][j] = min;
			}
		}
		return m[1][n];
	}
}
		
