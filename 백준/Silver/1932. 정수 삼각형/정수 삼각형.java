import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int j = 0; j < N; j++) {
            dp[N-1][j] = arr[N-1][j];
        }


        for (int i = N-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = arr[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}