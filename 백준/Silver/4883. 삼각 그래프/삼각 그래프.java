
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        final int INF = 1_000_000_000;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            cnt++;

            int[][] a = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                a[i][0] = Integer.parseInt(st.nextToken());
                a[i][1] = Integer.parseInt(st.nextToken());
                a[i][2] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N][3];
          
            dp[0][0] = INF;                
            dp[0][1] = a[0][1];          
            dp[0][2] = a[0][1] + a[0][2]; 

            if (N == 1) {
                sb.append(cnt).append(". ").append(dp[0][1]).append('\n');
                continue;
            }

  
            dp[1][0] = a[1][0] + dp[0][1];
            dp[1][1] = a[1][1] + Math.min(Math.min(dp[0][1], dp[0][2]), dp[1][0]);
            dp[1][2] = a[1][2] + Math.min(Math.min(dp[0][1], dp[0][2]), dp[1][1]);

    
            for (int i = 2; i < N; i++) {
                dp[i][0] = a[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = a[i][1] + Math.min(Math.min(dp[i][0], dp[i - 1][0]),
                                             Math.min(dp[i - 1][1], dp[i - 1][2]));
                dp[i][2] = a[i][2] + Math.min(Math.min(dp[i][1], dp[i - 1][1]), dp[i - 1][2]);
            }

            sb.append(cnt).append(". ").append(dp[N - 1][1]).append('\n');
        }

        System.out.print(sb.toString());
    }
}