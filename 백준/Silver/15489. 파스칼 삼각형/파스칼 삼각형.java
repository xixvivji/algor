import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[r + w][r + w];
        dp[0][0] = 1;
        for (int i = 1; i < r + w; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j <= i; j++) {
                sum += dp[r - 1 + i][c - 1 + j];
            }
        }
        System.out.println(sum);
    }
}