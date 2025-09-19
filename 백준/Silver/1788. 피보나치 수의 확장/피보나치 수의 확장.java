
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a;
        long b;

        if (n == 0) {
            a = 0;
            b = 0;
        } else {
            int absN = Math.abs(n);
            long[] dp = new long[absN + 2];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= absN; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
            b = dp[absN];
            if (n > 0) {
                a = 1;
            } else {
                a = (absN % 2 == 0) ? -1 : 1;
            }
        }

        System.out.println(a);
        System.out.println(Math.abs(b));
    }
}