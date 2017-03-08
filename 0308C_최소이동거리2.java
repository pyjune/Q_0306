import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [][] t;
	static int [] p;
	static int [] used;
	static int min;
	static int cnt;
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
			cnt = 0;
			// min = 0x7fffffff;
			for(int i = 1; i<=N; i++)
				for(int j= 1; j<=N; j++)
					t[i][j] = sc.nextInt();
			used[1] = 1;
			p[0] = 1;
			//npr(1, N);
			npr2(1, N, 0);
			System.out.println("#"+tc+" "+min+" "+cnt);
		}
	}
	
	public static void npr2(int n, int k, int s)
	{
		if(n==k)
		{
			cnt++;
			if(s+t[p[k-1]][1]<min)
				min = s+t[p[k-1]][1];
		}
		else if(s>min)
			return;
		else
		{
			for(int i = 2; i<=k;i++) // 1은 고정으로 사용..
			{
				if(used[i]==0)
				{
					used[i] = 1;
					p[n] = i; // 인덱스와 사용할 값이 같으므로 i를 그냥 사용..
					npr2(n+1, k, s+t[p[n-1]][i]);
					used[i] = 0;
				}
			}
		}
	}
}
