import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            lists = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                lists[a].add(b);
                lists[b].add(a);
            }
            count = 0;
            dfs(1);
            System.out.println(count);
        }
    }

    static void dfs(int i) {
        visited[i] = true;
        for (int n : lists[i]) {
            if (!visited[n]) {
                count++;
                dfs(n);
            }
        }
    }
}