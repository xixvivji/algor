
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());

            int[][] arr = new int[K + 1][N + 1];

     
            for (int i = 1; i <= N; i++) {
                arr[0][i] = i;
            }

        
            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }

            System.out.println(arr[K][N]);
        }
    }
}