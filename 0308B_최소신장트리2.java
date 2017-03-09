import java.util.*;
import java.io.FileInputStream;

public class Solution {
	static int V;
	static int E;
	
	static int mst[]; // mst 포함 여부
	static int last;
	static int [][] Q;
	static int [] t;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			adj = new int[V+1][V+1];
			mst = new int[V+1];
			last = 0;
			Q = new int[E+1][3];
			t = new int[3];
			for(int i=0;i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int w=sc.nextInt();
		
				enQ(n1, n2, w);
			}

			int sum = Kruskal();
			System.out.println("#"+tc+" "+sum);
		}
	}
	public static int Kruskal()
	{
		int sum = 0;
		for(int i =0 ; i<=V; i++)
			mst[i]= i; // 각자 대표 노드
		while(last>0)
		{
			deQ();
			int c0 = t[0];
			// 대표원소 조사
			while(mst[c0]!=c0)
			{
				c0=mst[c0];
			}
			int c1 = t[1];
			while(mst[c1]!=c1)
			{
				c1=mst[c1];
			}
			if(c0!=c1) //대표원소가 다르면
			{
				mst[c1] = c0; // mst에 추가
				sum+=t[2]; // 비용 추가
			}
		}
		return sum;
	}
	public static void enQ(int n1, int n2, int w)
	{
		int c = ++last;
		int p = c / 2;
		//Q[c] = n;
		Q[last][0] = n1;
		Q[last][1] = n2;
		Q[last][2] = w;
		while( Q[p][2] > Q[c][2] && c>1 )
		{

			for(int i=0; i<3; i++)
			{
				Q[0][i] = Q[p][i];
				Q[p][i] = Q[c][i];
				Q[c][i] = Q[0][i];
			}
			c= p;
			p = p/2;
		}	
	}
	
	public static void deQ()
	{
		t[0] = Q[1][0];
		t[1] = Q[1][1];
		t[2] = Q[1][2];
		// root <- Q[last]
		for(int i=0; i<3; i++)
		{
			Q[1][i] = Q[last][i];
		}
		
		last--;
		int p = 1;
		while(p<last)
		{
			int c1 = p * 2;
			int c2 = p * 2 + 1;
			if(c2<=last)
			{
				int c = Q[c1][2]<Q[c2][2]?c1:c2;
				if( Q[c][2] < Q[p][2] )
				{
					for(int i=0; i<3; i++)
					{
						Q[0][i] = Q[p][i];
						Q[p][i] = Q[c][i];
						Q[c][i] = Q[0][i];
					}
					p = c;
				}
				else
					break;
			}
			else if(c1<=last)
			{
				if(Q[c1][2]<Q[p][2])
				{
					for(int i=0; i<3; i++)
					{
						Q[0][i] = Q[p][i];
						Q[p][i] = Q[c1][i];
						Q[c1][i] = Q[0][i];
					}
					p = c1;
				}
				else
					break;
			}
			else
				break;
		}
		
	}
	
}
