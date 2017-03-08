import java.util.*;
import java.io.FileInputStream;

public class Main {
	static int N;
	static int [][] map; // 높이 정보
	static int [][] d; // 누적 연료 소비량
	static int [][] u; // 경유지로 고려 여부 기록

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			N = sc.nextInt();
			map = new int[N][N];
			d = new int[N][N];
			u = new int[N][N];
			for(int i=0; i<N; i++)
			{
				for(int j=0;j<N;j++)
				{
					map[i][j]=sc.nextInt();
					d[i][j]=Integer.MAX_VALUE; // d[][]초기화
				}
			}

					
			//dij();
			bfs();
			System.out.println("#"+tc +" "+d[N-1][N-1]);
		}
	}
	// 단순반복 dijkstra : Time out...
	public static void dij()
	{
		int dr[] = {0, 1, 0, -1};
		int dc[] = {1, 0, -1, 0};
		int cnt = 0;
		int tr = 0;
		int tc = 0;
		
		d[0][0] = 0;

		while(cnt<N*N)
		{
			// d[][]가 최소인 r, c 검색...
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<N;i++)
			{
				for(int j= 0; j<N; j++)
				{
					if(u[i][j]==0 && d[i][j]<min)// 경유지가 아니면서 최소인 곳
					{
						min = d[i][j];
						tr = i;
						tc = j;
					}
				}
			}
			// (tr, tc)의 인접에 대해 기존 비용과 (tr, tc)를 거쳐 가는 비용 비교
			u[tr][tc] = 1; // 경유지로 고려했음을 표시
			for(int i = 0 ; i<4; i++)
			{
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				if((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<N)) // 유효한 범위면
				{
					if(u[nr][nc]==0) // 경유지 제외
					{
						int diff = 0;
						if(map[nr][nc]>map[tr][tc]) // 높이 차에 의한 연료 소비
							diff = map[nr][nc]-map[tr][tc];
								
						int tmp = d[tr][tc]+1+diff; // tr,tc를 거쳐 nr,nc로 가는 비용 
						d[nr][nc] = (d[nr][nc]>tmp)?tmp:d[nr][nc];
					}
				}
			}
			cnt++;
		}
	}
	public static void bfs()
	{
		int dr[] = {0, 1, 0, -1};
		int dc[] = {1, 0, -1, 0};

		// queue
		int front = -1; 
		int rear = -1;
		int qr[] = new int [10000000];
		int qc[] = new int [10000000];
		
		rear++;
		qr[rear]=0; // 시작점 enqueue
		qc[rear]=0;
		d[0][0] = 0;
		while(front!=rear)
		{
			// dequeue
			front++;
			int tr = qr[front];
			int tc = qc[front];
			for(int i = 0 ; i<4; i++)
			{
				int nr = tr + dr[i];
				int nc = tc + dc[i];
				if((nr>=0)&&(nr<N)&&(nc>=0)&&(nc<N)) // 유효한 범위면
				{
					int diff = 0;
					if(map[nr][nc]>map[tr][tc]) // 높이 차에 의한 연료 소비
						diff = map[nr][nc]-map[tr][tc];
							
					int tmp = d[tr][tc]+1+diff; // tr,tc를 거쳐 nr,nc로 가는 비용 
					if(d[nr][nc]>tmp)
					{
						d[nr][nc] = tmp;
						rear++;
						qr[rear]=nr;
						qc[rear]=nc;
						
					}					
				}
			}
		}
		
	}
}
