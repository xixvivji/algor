import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[Math.max(n + 1, 2)];
        dp[0] = 1;
        dp[1] = 1;
        System.out.println(f(n));
    }

    static long f(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = (f(n - 1) + f(n - 2) + 1) % MOD;
    }
}