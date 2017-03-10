import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static long [][]m;

	
	public static void main(String[] args) throws Exception{

		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		m = new long [71][71];
		makem();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#"+tc+" "+m[n][a]);
			
		}
	}
	public static void makem()
	{
		for(int i = 0; i<=70; i++)
		{
			for(int j=0; j<=i; j++)
			{
				if(i==j || j==0)
					m[i][j] = 1;
				else
					m[i][j] = m[i-1][j-1]+m[i-1][j];
			}
		}
	}
}
