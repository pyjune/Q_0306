/* input.txt
1
5 6
1 2 3
1 3 1
3 2 1
2 5 4
3 4 2
5 4 2
 */

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int V;
	static int E;
	static int adj[][];
	static int u[];
	static int dis[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{			
			V = sc.nextInt();
			E = sc.nextInt();
			adj = new int[V+1][V+1];
			dis = new int[V+1];
			u = new int[V+1];
			for(int i=1; i<=V; i++)
			{
				for(int j =1; j<=V;j++)
				{
					if(i==j)
						adj[i][j]=0;
					else
						adj[i][j]=Integer.MAX_VALUE;		
				}
			}
			for(int i =0 ;i<E; i++)
			{
				int n1=sc.nextInt();
				int n2=sc.nextInt();
				int w=sc.nextInt();
				adj[n1][n2] = w;
			}
			dij(1);
			for(int i=1; i<=V; i++)
				System.out.print(dis[i]+" ");
			System.out.println();
		}
	}
	public static void dij(int s)
	{
		int cnt = 1;
		u[s] = 1;
		for(int i = 1; i<=V; i++)
		{
			dis[i] = adj[s][i]; // dis[] 초기화
		}
		while(cnt<V)// 남은 노드가 있으면(u[]==0)
		{
			//u[t]==0 && d[t]가 최소인 t검색
			int min = Integer.MAX_VALUE;
			int t=0;
			for(int i =1;i<=V;i++)
			{
				if(u[i]==0)
				{
					if(dis[i]<min)
					{
						min=dis[i];
						t = i;
					}
				}
			}
			//t를 경유지로 고려해서, t와 인접인 노드의 비용 계산
			u[t] =1;
			for(int i = 1; i<=V; i++)
			{
				if(adj[t][i]!=0 && adj[t][i]!=Integer.MAX_VALUE)
				{
					dis[i]=(dis[i]>dis[t]+adj[t][i])?(dis[t]+adj[t][i]):dis[i];
				}
			}
			cnt++;
		}
	}
}
