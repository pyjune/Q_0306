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
			
			for(int i = 0; i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				adj[n1][n2] = 1;
				adj[n2][n1] = 1; // 무향인 경우..
			}
			bfs(1);
			int sum = 0;
			for(int i = 1; i<=V; i++)
				sum += visited[i];
			sum -= V;
			System.out.println("#"+tc+" "+sum);
		}
	}
	public static void bfs(int n)
	{
		//초기화
		Q[++rear] = n;
		visited[n] = 1;
		//큐가 비어있지 않으면 반복
		while( front != rear)
		{
			n = Q[++front]; // dequeue
			for(int i =1; i<=V; i++)
			{
				if(adj[n][i]==1 && visited[i]==0)
				{
					Q[++rear] = i;
					visited[i] = visited[n] + 1;
				}
			}
		}
	}
}
