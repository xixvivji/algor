import java.io.*;
import java.util.*;

public class Main {
		static Long []dp;
		static Long []arr;
	    public static void main(String[] args) throws Exception {
	    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    		dp = new Long[1001];
	    		 dp[1] = 1L;
	    		 dp[2] = 2L;
	    		int n = Integer.parseInt(br.readLine());
	    		
	    		for(int i = 3; i<=n ; i++) {
	    			  dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
	    			
	    		}
	    	       
	    		System.out.println(dp[n]);
	    		 
	   }
	    
}