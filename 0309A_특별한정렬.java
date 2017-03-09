import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Main {

	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int [] arr;

		for(int tc = 1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			arr = new int[N];
			
			for(int i = 0; i<N; i++)
			{
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			System.out.print("#"+tc);
			int minIdx = 0;
			int maxIdx = N-1;
			for(int i = 0 ;i<5; i++)
			{
				System.out.print(" "+arr[maxIdx]+" "+arr[minIdx]);
				maxIdx--;
				minIdx++;
			}
			System.out.println();
		}
	}

}
