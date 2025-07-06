
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

	
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int sum = 0;
            for(int i = 0; i < 10; i++){
		int  a = sc.nextInt();
            sum += a;
            
            }
            long avg = Math.round(sum / 10.0);
               System.out.println("#" + test_case + " " + avg);
		}
      
	}
}