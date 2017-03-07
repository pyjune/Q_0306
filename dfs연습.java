import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int V;
	static int E;
	static int adj[][];
	static int visited[];
	static int cnt; // find()
	static int min; // find2()
	static int cnt2;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			adj = new int[V+1][V+1];
			visited = new int[V+1];
			cnt = 0;
			min = Integer.MAX_VALUE; // 0x7fffffff
			cnt2=0;
			for(int i = 0; i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				adj[n1][n2] = 1;
				//adj[n2][n1] = 1; // 무향인 경우..
			}
			//dfs(1);
			//find(1,4);
			//System.out.println(cnt);
			find2(1,4,0);
			System.out.println(min+":"+cnt2);
		}
	}
	public static void dfs(int n)
	{
		visited[n] = 1; // 방문표시
		System.out.print(n+" "); //visit()
		for(int i=1; i<=V; i++) // 모든 노드 i에 대해..
		{
			if(adj[n][i]==1 && visited[i]==0) // i가 인접하고 방문하지 않은 노드면
			{
				dfs(i);
			}
		}
	}
	// n에서 k까지 경로의 수 찾기
	public static void find(int n, int k)
	{
		if(n==k)
		{
			cnt++;
		}
		else
		{
			visited[n] = 1; // 방문표시
			//System.out.print(n+" "); //visit()
			for(int i=1; i<=V; i++) // 모든 노드 i에 대해..
			{
				if(adj[n][i]==1 && visited[i]==0) // i가 인접하고 방문하지 않은 노드면
				{
					find(i, k);
				}
			}
			visited[n] = 0; // 방문표시 해제
		}
	}
	// n에서 k까지 최단거리
	public static void find2(int n, int k, int e)
	{
		if(n==k)
		{
			cnt2++;
			if(min>e)
				min = e;
		}
		else if(e>=min) // 백트래킹...
			return;
		else
		{
			visited[n] = 1; // 방문표시
			//System.out.print(n+" "); //visit()
			for(int i=1; i<=V; i++) // 모든 노드 i에 대해..
			{
				if(adj[n][i]==1 && visited[i]==0) // i가 인접하고 방문하지 않은 노드면
				{
					find2(i, k, e+1);
				}
			}
			visited[n] = 0; // 방문표시 해제
		}
	}
}
