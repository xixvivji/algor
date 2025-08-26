import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class Main {
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());

	        boolean[] dp = new boolean[1001];

	        dp[1] = false; 
	        dp[2] = true;  
	        dp[3] = false; 
	        dp[4] = true; 

	        for (int i = 5; i <= n; i++) {
	            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
	                dp[i] = true;
	            } else {
	                dp[i] = false; 
	            }
	        }

	        if (dp[n]) {
	            System.out.print("SK"); 
	        } else {
	            System.out.print("CY");
	        }
	    }
	}