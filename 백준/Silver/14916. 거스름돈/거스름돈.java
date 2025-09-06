
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int dp[] = new int[1000000];

        dp[1] = Integer.MAX_VALUE;
        dp[2] = 1;
        dp[3] = Integer.MAX_VALUE;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 5], dp[i - 2]) + 1;
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}