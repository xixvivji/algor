import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            dp[0] = arr[0];
            int max = arr[0];
            for (int j = 1; j < N; j++) {
                dp[j] = Math.max(arr[j], dp[j - 1] + arr[j]);
                max = Math.max(max, dp[j]);
            }
            System.out.println(max);
        }
    }
}