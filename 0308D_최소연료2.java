import java.util.*;
import java.io.FileInputStream;

public class Solution {
	static int N;
	static int [][] map; // 높이 정보
	static int [][] d; // 누적 연료 소비량
	static int [][] u; // 경유지로 고려 여부 기록
	static int last; // 우선순위큐의 마지막 노드 인덱스
	static int [][] Q;
	static int t[]; // dequeue한 값을 저장할 배열..
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			N = sc.nextInt();
			map = new int[N][N];
			d = new int[N][N];
			u = new int[N][N];
			last = 0;
			Q = new int[N*N][3];
			t = new int[3];
			
			for(int i=0; i<N; i++)
			{
				for(int j=0;j<N;j++)
				{
					map[i][j]=sc.nextInt();
					d[i][j]=Integer.MAX_VALUE; // d[][]초기화
					
				}
			}
			dij2();
			System.out.println("#"+tc +" "+d[N-1][N-1]);
		}
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
