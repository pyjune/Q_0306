// 모든 부분 집합을 만들어서 해결하는 경우..
// 두 번째 테스트케이스까지만 적용 가능

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [] L;
	static int [] arr;
	static int cnt;
	static int cnt2;
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<= T; tc++)
		{
			int N = sc.nextInt();
			int sum_K = sc.nextInt();

			arr = new int[N];
			L = new int [N];
			cnt = 0;
			cnt2 = 0;
			int rs = 0;
			for(int i = 0; i<N; i++)
			{
				arr[i] = i+1;
				rs += i+1;
			}
			// int rs = (1+N)*N/2;
			//subset_sum(0, N, sum_K);
			//subset_sum2(0, N, sum_K, 0);
			subset_sum3(0, N, sum_K, 0, rs);
			System.out.println("#"+tc+" "+cnt+" "+cnt2);
			// System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	public static void subset_sum3(int n, int k, int sum_k, int s, int rs)
	{
		int sum =0;
		if(n==k)
		{
			cnt2++;
			if(s==sum_k)
				cnt++;
			return;
		}
		else if(s>sum_k)
		{
			return;
		}
		else if(s+rs<sum_k)
		{
			return;
		}
		else
		{
			L[n] = 0;
			subset_sum3(n+1, k, sum_k, s, rs-arr[n]);
			L[n] = 1;
			subset_sum3(n+1, k, sum_k, s+arr[n], rs-arr[n]);
			/*
			for(int i=0; i<=1; i++)
			{
				L[n] = i;
				subset_sum2(n+1, k, sum_k, s+arr[n]*i, rs-arr[n]);
			}
			*/
		}
	}
	public static void subset_sum2(int n, int k, int sum_k, int s)
	{
		int sum =0;
		if(n==k)
		{
			cnt2++;
			if(s==sum_k)
				cnt++;
			return;
		}
		else if(s>sum_k)
		{
			return;
		}
		else
		{
			L[n] = 0;
			subset_sum2(n+1, k, sum_k, s);
			L[n] = 1;
			subset_sum2(n+1, k, sum_k, s+arr[n]);
			/*
			for(int i=0; i<=1; i++)
			{
				L[n] = i;
				subset_sum2(n+1, k, sum_k, s+arr[n]*i);
			}
			*/
		}
	}
	
	public static void subset_sum(int n, int k, int sum_k)
	{
		int sum =0;
		if(n==k)
		{
			cnt2++;
			for(int i = 0; i<k; i++)
			{
				if(L[i] == 1)
					sum += arr[i];
			}
			if( sum == sum_k)
			{
				cnt++;
			}

			return;
		}
		else
		{
			for(int i=0; i<=1; i++)
			{
				L[n] = i;
				subset_sum(n+1, k, sum_k);
			}

		}
	}

}
