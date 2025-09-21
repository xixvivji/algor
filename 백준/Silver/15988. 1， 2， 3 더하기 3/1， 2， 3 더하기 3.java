import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000009;
    static final int MAX = 1000000; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[MAX + 4];
        dp[0] = 1; 
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= MAX; i++) {
            dp[i] = (int)(((long)dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD);
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }
        System.out.print(sb);
    }
}