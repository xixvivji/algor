import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class Main {
	

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       int[] dp = new int[1001];
       int N = Integer.parseInt(br.readLine());
       dp[0]= 0;
       dp[1] = 1;
       dp[2] = 2;
       dp[3] = 1;
       for (int i = 4; i <= N; i++) {
           dp[i] = Math.min(dp[i - 1] + 1, dp[i - 3]) + 1;
       }
            
       if (dp[N] % 2 == 0) {
           System.out.println("SK");
       } else {
           System.out.println("CY");
       }

        
    }
}