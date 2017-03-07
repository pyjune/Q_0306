/*
1
6 7
1 2 1 3 3 2 6 3 3 4 5 4 2 5
*/




import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int V;
	static int E;
	static int adj[][];
	static int visited[];
	static int [] Q;
	static int front;
	static int rear;
	static int ind[];
	static int coin[];
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
			Q = new int[V+1];
			front = -1;
			rear = -1;
			ind = new int[V+1];
			coin = new int[V+1];
			for(int i = 0; i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				adj[n1][n2] = 1;
				ind[n2]++; // 진입차수 계산
			}
			int max = 0;
			//tsort();
			//for(int i = 1; i<=V; i++) // coin[i] 중 최대값 찾기...
			//	if(max<coin[i])
			//		max = coin[i];
			max = tsort2();
			System.out.println("#"+tc+" "+max);
		}
	
	}
	public static void tsort()
	{
		for(int i =1;i<=V; i++) // 진입차수가 0인 모든 노드를 enqueue
		{
			if(ind[i]==0)
			{
				Q[++rear] = i;
				coin[i] = 1;
			}
		}
		while( front != rear)
		{
			int n = Q[++front]; // dequeue
			for(int i = 1 ; i<=V; i++)
			{
				if(adj[n][i]==1)
				{
					ind[i]--; // 인접노드의 진입차수를 빼줌.
					if(ind[i]==0)
					{
						Q[++rear] = i; // 진입차수가 0이된 노드는 처리를 위해 대기..
						int max=0;
						for(int j=1;j<=V;j++)
						{
							if(adj[j][i]==1) // i로 진입하는 노드에 대해..
							{
								if(max<coin[j]) // 가장 많은 동전을 찾고..
									max = coin[j];
							}
						}
						coin[i] = max+1; // 내 비교대상 중 가장 많은 동전 개수 + 1
					}
				}
			}
		}
	}
	public static int tsort2()
	{
		int max_coin=0;
		for(int i =1;i<=V; i++) // 진입차수가 0인 모든 노드를 enqueue
		{
			if(ind[i]==0)
			{
				Q[++rear] = i;
				coin[i] = 1;
			}
		}
		while( front != rear)
		{
			int n = Q[++front]; // dequeue
			for(int i = 1 ; i<=V; i++)
			{
				if(adj[n][i]==1)
				{
					ind[i]--; // 인접노드의 진입차수를 빼줌.
					if(ind[i]==0)
					{
						Q[++rear] = i; // 진입차수가 0이된 노드는 처리를 위해 대기..
						int max=0;
						for(int j=1;j<=V;j++)
						{
							if(adj[j][i]==1) // i로 진입하는 노드에 대해..
							{
								if(max<coin[j]) // 가장 많은 동전을 찾고..
									max = coin[j];
							}
						}
						coin[i] = max+1; // 내 비교대상 중 가장 많은 동전 개수 + 1
						if(max_coin<coin[i]) // coin[i] 중 최대값 찾기...
							max_coin=coin[i];
					}
				}
			}
		}
		return max_coin;
	}
}
