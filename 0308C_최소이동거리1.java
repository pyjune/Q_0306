import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [][] t;
	static int [] p;
	static int [] used;
	static int min;
	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			int N = sc.nextInt();
			t = new int[N+1][N+1];
			p = new int[N];
			used = new int[N+1];
			min = Integer.MAX_VALUE;
			// min = 0x7fffffff;
			for(int i = 1; i<=N; i++)
				for(int j= 1; j<=N; j++)
					t[i][j] = sc.nextInt();
			used[1] = 1;
			p[0] = 1;
			npr(1, N);
			System.out.println("#"+tc+" "+min);
		}
	}
	public static void npr(int n, int k)
	{
		if(n==k)
		{
			int sum = 0;
			int i;
			for(i = 0; i<k-1; i++)
			{
				sum += t[p[i]][p[i+1]];
			}
			sum += t[p[i]][1];
			//System.out.println(sum);
			if(sum<min)
				min = sum;
		}
		else
		{
			for(int i = 2; i<=k;i++) // 1은 고정으로 사용..
			{
				if(used[i]==0)
				{
					used[i] = 1;
					p[n] = i; // 인덱스와 사용할 값이 같으므로 i를 그냥 사용..
					npr(n+1, k);
					used[i] = 0;
				}
			}
		}
	}
}
