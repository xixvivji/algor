
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] days = new int[M + 1];
        int[] pages = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = N; j >= days[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - days[i]] + pages[i]);
            }
        }

        System.out.println(dp[N]);
    }
}