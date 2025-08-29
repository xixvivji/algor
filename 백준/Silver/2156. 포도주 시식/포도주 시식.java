import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N];


        dp[0] = arr[0];
        if (N > 1) dp[1] = arr[0] + arr[1];
        if (N > 2) dp[2] = Math.max(arr[0] + arr[2], Math.max(arr[1] + arr[2], dp[1]));

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i-1], 
                        Math.max(dp[i-2] + arr[i], 
                                 dp[i-3] + arr[i-1] + arr[i]));
        }

        System.out.println(dp[N-1]);
    }
}