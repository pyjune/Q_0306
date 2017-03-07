import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [][] map;
	static int N; // 미로의 크기
	static int min;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++)
		{
			N = sc.nextInt();
			map = new int [N][N];
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
			find(str, stc, 0);
			if(min==Integer.MAX_VALUE)
				min = 0;
			else
				min--; // 도착칸이 포함되어 있으므로..
			System.out.println("#"+tc+" "+min);

		}
	}
	public static void find(int r, int c, int s)
	{
		int [] dr = { 0, 1, 0, -1};
		int [] dc = { 1, 0, -1, 0};
		if(map[r][c]==3)
		{
			if(min>s)
				min = s;
		}
		else
		{
			map[r][c] = 1;
			for(int i = 0; i<4; i++)
			{
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(map[nr][nc] != 1)
				{
					find(nr, nc, s+1);
		
				}
			}
			map[r][c] = 0;
		}
	}
}
