import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0, 0);
        System.out.println(min);
    }


    static void dfs(int i, int sour, int bitter, int cnt) {
        if (i == N) {
            if (cnt > 0) {
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }
        dfs(i + 1, sour * arr[i][0], bitter + arr[i][1], cnt + 1);
        dfs(i + 1, sour, bitter, cnt);
    }
}