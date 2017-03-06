import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int [][] arr;

		for(int tc = 1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			arr = new int[N][N];
			
			for( int i = 0; i<N; i++ )
			{
				for(int j =0; j<N; j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for(int i=0; i<=N-n; i++)
			{
				for(int j=0; j<=N-m; j++)
				{
					int sum = 0;
					for(int x = 0; x<n; x++)
					{
						for(int y = 0; y< m ; y++)
						{
							sum += arr[i+x][j+y];
						}
					}
					if(max<sum)
						max = sum;
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}

