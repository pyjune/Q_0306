import java.util.*;
import java.awt.Point;
import java.io.FileInputStream;

public class Solution {
	static int [][] map;
	static int [][] visited;
	static int N; // 미로의 크기
	static int min;
	static int [][] q;
	static int front;
	static int rear;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			N = sc.nextInt();
			map = new int [N][N];
			visited = new int [N][N];
			
			int str = 0;
			int stc = 0;
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++)
			{
				String st = sc.next();
				for(int j = 0; j<N; j++)
				{
					map[i][j] = st.charAt(j)-'0';
					if(map[i][j]==2)
					{
						str = i;
						stc = j;
					}
				}
			}
      // int r = bfs(str, stc);
			int r = bfs2(str, stc);
			
			System.out.println("#"+tc+" "+r);

		}
	}
	public static int bfs2(int r, int c)
	{
		int [] dr = {0, 1, 0, -1};
		int [] dc = {1, 0, -1, 0};
		// 큐 생성 + enqueue()
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		visited[r][c] = 1;
		while(!q.isEmpty())
		{
			// deQ();
			Point p = q.poll();
			for(int i = 0; i<4; i++) // 4방향에 대해..
			{
				int nr = p.x+dr[i];
				int nc = p.y+dc[i];
				if(map[nr][nc]==3)
				{
					return visited[p.x][p.y]-1; // 출발점을 빼야함..
				}
				else if( map[nr][nc]!=1 && visited[nr][nc]==0)// 인접&&미방문..
				{
					//enQ()
					q.add(new Point(nr, nc));
					visited[nr][nc] = visited[p.x][p.y]+1;
				}
			}
			
		}
		return 0; 
	}
	public static int bfs(int r, int c)
	{
		int [] dr = {0, 1, 0, -1};
		int [] dc = {1, 0, -1, 0};
		// 큐 생성
		q = new int[N*N][2];
		front = -1;
		rear = -1;
		// enQ()
		rear++;
		q[rear][0] = r;
		q[rear][1] = c;
		visited[r][c] = 1;
		while(front != rear)
		{
			// deQ();
			front++;
			r = q[front][0];
			c = q[front][1];
			for(int i = 0; i<4; i++) // 4방향에 대해..
			{
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(map[nr][nc]==3)
				{
					return visited[r][c]-1; // 출발점을 빼야함..
				}
				else if( map[nr][nc]!=1 && visited[nr][nc]==0)// 인접&&미방문..
				{
					//enQ()
					rear++;
					q[rear][0] = nr;
					q[rear][1] = nc;
					visited[nr][nc] = visited[r][c]+1;
				}
			}
			
		}
		return 0; 
	}
}
