import java.util.*;
import java.io.FileInputStream;

public class Solution {
	static int V;
	static int E;
	static int [][] adj; // 인접행렬
	static int [] maxlen; // 노드별 최장거리
	static int [] ind; // 진입차수
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			adj = new int[V+1][V+1];
			maxlen = new int[V+1];
			ind = new int[V+1];
			for(int i=0;i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int w=sc.nextInt();
				adj[n1][n2] = w;
				ind[n2]++;	// 진입차수
			}
			tsort2();
			System.out.println("#"+tc+" "+maxlen[V]);
		}
	}
	public static void tsort()
	{
		int [] q = new int[V*V];
		int front = -1;
		int rear = -1;
		
		for(int i = 0; i<=V; i++)
		{
			if(ind[i]==0)	// 진입차수 0이면 enQ();
				q[++rear] = i;
		}
		while(front!=rear)  // q가 비어있지 않으면 반복
		{
			int t = q[++front]; // deQ();
			int max = 0;
			// visit(t)
			for(int i=0;i<=V;i++) // t까지의 가장 큰 진입 비용 찾기
			{
				if(adj[i][t]!=0)
				{
					if(maxlen[i]+adj[i][t]>max)
						max = maxlen[i]+adj[i][t];
				}
			}
			maxlen[t] = max;
			// t의 인접노드에 대해 진입차수 감소..
			for(int i = 0; i<=V; i++)
			{
				if(adj[t][i]!=0)
				{
					ind[i]--;
					if(ind[i]==0) // i의 진입차수가 0이 되면 enQ()
						q[++rear] = i;
				}
			}
		} 
	}
	public static void tsort2()
	{
		Queue <Integer> q = new LinkedList<>();

		
		for(int i = 0; i<=V; i++)
		{
			if(ind[i]==0)	// 진입차수 0이면 enQ();
				q.add(i);
		}
		while(!q.isEmpty())  // q가 비어있지 않으면 반복
		{
			int t = q.poll(); // deQ();
			int max = 0;
			// visit(t)
			for(int i=0;i<=V;i++) // t까지의 가장 큰 진입 비용 찾기
			{
				if(adj[i][t]!=0)
				{
					if(maxlen[i]+adj[i][t]>max)
						max = maxlen[i]+adj[i][t];
				}
			}
			maxlen[t] = max;
			// t의 인접노드에 대해 진입차수 감소..
			for(int i = 0; i<=V; i++)
			{
				if(adj[t][i]!=0)
				{
					ind[i]--;
					if(ind[i]==0) // i의 진입차수가 0이 되면 enQ()
						q.add(i);
				}
			}
		} 
	}
}
