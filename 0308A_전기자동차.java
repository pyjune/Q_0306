import java.util.Scanner;
import java.io.FileInputStream;
public class Solution {
	static int [] batt;
	static int min;
	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<= T; tc++)
		{
			int N = sc.nextInt();
			min = 10;
			batt = new int[N-1];
			for(int i= 0; i<N-1; i++)
				batt[i] = sc.nextInt();
			next(0, N-1, 0, 0);
			min--; // 출발지의 교체 횟수는 제외..(문제 조건 참조..)
			// next(1, N-1, batt[0]-1, 0);  // 1번 정류장부터 고려하는 경우
			System.out.println("#"+tc+" "+min);
		}
	}
	// n 정류장, k 종점, e 정류장 도착시 남은 에너지, c 이전까지의 교체 횟수
	public static void next(int n, int k, int e, int c)
	{
		if(n==k) // 종점 도착..
		{
			if(min>c) // 교체 횟수가 기존의 최소 횟수보다 작으면
				min = c; // 새로운 최소값으로 갱신
		}
		else // 종점 이전 정류장
		{
			if(e>0) // 통과는 에너지가 남아 있어야 가능..
			{
				next(n+1, k, e-1, c);
			}
			// 교체는 에너지 유무에 상관없이.. 
			next(n+1, k, batt[n]-1, c+1);
		}
	}
	

}
