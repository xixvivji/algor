
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.StringTokenizer;
public class Main {
	
	static final int pisano = 15 * 100000;
	public static void main(String[] args) throws IOException {
		// 피사노 주기
		// M = 10^k - > k > 2 , 주기는 15 * 10^(K-1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        N %= pisano;
        long dp[] = new long[(int) N +1];
        
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%1000000;
		}
        System.out.println(dp[(int)N]);
    }
}