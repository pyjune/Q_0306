
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
 
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int hex;
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
				for(int bit = 3; bit>=0; bit--)
				{
					if((num & 1<<bit) == 0)
						System.out.print("0");
					else
						System.out.print("1");
				}
			}
			
			System.out.println();
			
		}
	}

}

