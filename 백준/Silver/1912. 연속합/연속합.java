import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class Main {
	
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int n = Integer.parseInt(br.readLine());
        int []arr = new int [n+1];
        int []dp = new int [n+1];
        dp[0] = 0;
        int max = -9999;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        dp[1] = arr[1];
        for(int i = 1; i< dp.length;i++) {
        	dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        	max = Math.max(max, dp[i]);
        }
        	System.out.println(max);
        
		
        
	}
}