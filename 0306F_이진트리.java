import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [] c1;
	static int [] c2;
	static int [] par;
	static int cnt;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			int E = sc.nextInt();
			int N = sc.nextInt();
			c1 = new int[E+2]; // 노드번호를 1번부터 사용하는 경우..
			c2 = new int[E+2];
			par = new int[E+2];
			cnt = 0;
			for(int i=0;i<E;i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				// 부모를 인덱스로 자식을 저장..
				if( c1[n1] == 0)
					c1[n1] = n2; // 첫번째 자식인 경우..
				else
					c2[n1] = n2; // 자식이 두 개인 경우..
				// 자식을 인덱스로 부모를 저장
				par[n2] = n1;
			}
			DLR(N); // root가 1이고 1번부터 순회하는 경우..
			cnt--; // N번 노드는 제외..
			int r = search(N);
			System.out.println("#"+tc+" "+r+" "+cnt);
		}
	}
	public static void DLR(int n)
	{
		if(n!=0)
		{
			cnt++;
			DLR(c1[n]);
			DLR(c2[n]);
		}
	}
	public static int search(int c)
	{
		int ans = 0;
		while(par[c]!=0)
		{
			c = par[c];
			ans++;
		}
		return ans;
	}

}
