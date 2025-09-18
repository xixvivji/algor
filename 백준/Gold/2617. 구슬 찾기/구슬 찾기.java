
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] down, up;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        down = new ArrayList[N + 1];
        up = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            down[i] = new ArrayList<>();
            up[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            down[a].add(b);
            up[b].add(a);
        }

        int half = N / 2;
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            int lighter = bfsCount(i, down);
            int heavier = bfsCount(i, up);
            if (lighter > half || heavier > half) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static int bfsCount(int start, List<Integer>[] adj) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        int cnt = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}