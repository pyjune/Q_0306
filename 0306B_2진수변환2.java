import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
 
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int hex;
		int [] bit;
		for(int tc = 1; tc<=T;tc++)
		{
			int N = sc.nextInt();
			String str = sc.next();
			int num = 0;
			System.out.print("#"+tc+" ");
			for(int i= 0; i<N; i++)
			{
				if(str.charAt(i)>='A')
					num = str.charAt(i) - 'A' +10;
				else
					num = str.charAt(i) - '0';
				int j = 3;
				bit = new int[4];
				while(j>=0 && num>0)
				{
					bit[j--] = num%2;
					num /= 2;
				}
				for(int k=0; k<4; k++)
					System.out.print(bit[k]);
			}
			
			System.out.println();
			
		}
	}

}

