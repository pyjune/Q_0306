import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
 
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int [][] m;
		int T = sc.nextInt();

		for(int tc = 1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			int row = sc.nextInt();
			int col = sc.nextInt();
			m = new int[N][N];
			int v = 1;
			
			for(int l = 1; l<N; l++)
			{
				for(int i= 0; i<N-l; i++)
				{
					int j= i+l;
					m[i][j] = v++;
				}
			}
			System.out.println("#"+tc+" "+m[row][col]);
			
		}
	}

}

