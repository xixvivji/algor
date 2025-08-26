
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class Main {
	

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] dp = new int[31][31];

        // 조합의 기본 조건 설정: C(n, 0) = 1, C(n, n) = 1
        for (int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        // C(n, k) = C(n-1, k-1) + C(n-1, k)
        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine()); 

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()); 
            System.out.println(dp[M][N]);

        }

        
    }
}