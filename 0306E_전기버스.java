import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {

	static int[] a;
	static int K;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			K = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			a = new int[M+2];
			for(int i=1; i<=M;i++)
			{
				a[i] = sc.nextInt();
			}
			a[M+1]=N;
			int r = find();
			System.out.println("#"+tc+" "+r);
		}
	}
	public static int find()
	{
		int cnt = 0;
		int last = 0;
		for(int i = 1; i<=M+1; i++)
		{
			if(a[i]-a[i-1]>K)
				return 0;
			if(a[i]>last+K)
			{
			
				last = a[i-1];
				cnt++;
			}
		}
		
		return cnt;
	}
}
