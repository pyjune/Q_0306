import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int V;
	static int E;
	static int [] c1;
	static int [] c2;
	static int [] par;
	static int cnt;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			c1 = new int[V+1];
			c2 = new int[V+1];
			par = new int[V+1];
			cnt = 0;
			for(int i = 0; i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				// 부모를 인덱스로 자식을 저장, 순회에 사용
				if(c1[n1]==0)
					c1[n1] = n2;
				else
					c2[n1] = n2;
				// 자식을 인덱스로 부모를 저장, 루트/조상찾기에 사용..
				par[n2]=n1;
			}
			DLR(3);
			System.out.println("#"+tc+" "+cnt);
		}
	}
	public static void DLR(int n)
	{
		if(n>0)
		{
			cnt++; //visit
			//System.out.print(n + " "); // visit(), 전위순회..
			DLR(c1[n]);
			//System.out.print(n + " "); // visit(), 중위순회..
			DLR(c2[n]);
			//System.out.print(n + " "); // visit(), 후위순회..
		}
	}

}
