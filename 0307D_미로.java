import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	static int [][] map;
	static int N; // 미로의 크기

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
			int r = find2(str, stc);
			System.out.println("#"+tc+" "+r);

		}
	}
	public static int find2(int r, int c)
	{
		int [] dr = { 0, 1, 0, -1};
		int [] dc = { 1, 0, -1, 0};
		if(map[r][c]==3)
		{
			return 1;
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
					if(find2(nr, nc)==1)
						return 1;
				}
				
			}
			return 0;
		}
	}
	public static int find(int r, int c)
	{
		if(map[r][c]==3)
		{
			return 1;
		}
		else
		{
			map[r][c] = 1;
			// 오른쪽
			if(map[r][c+1]!=1)
			{
				if(find(r, c+1)==1)
					return 1;
			}
			// 아래
			if(map[r+1][c]!=1)
			{
				if(find(r+1, c)==1)
					return 1;
			}
			// 왼쪽
			if(map[r][c-1]!=1)
			{
				if(find(r, c-1)==1)
					return 1;
			}
			// 위
			if(map[r-1][c]!=1)
			{
				if(find(r-1, c)==1)
					return 1;
			}
			return 0;
		}
	}
	
