
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, new boolean[N]);
        System.out.println(min);
    }

    static void dfs(int idx, boolean[] team) {
        if (idx == N) {
            int start = 0, link = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (team[i] && team[j]) {
                        start += arr[i][j];
                    }
                    if (!team[i] && !team[j]) {
                        link += arr[i][j];
                    }
                }
            }
            if (start != 0 && link != 0) {
                min = Math.min(min, Math.abs(start - link));
            }
            return;
        }
        team[idx] = true;
        dfs(idx + 1, team);
        team[idx] = false;
        dfs(idx + 1, team);
    }
}