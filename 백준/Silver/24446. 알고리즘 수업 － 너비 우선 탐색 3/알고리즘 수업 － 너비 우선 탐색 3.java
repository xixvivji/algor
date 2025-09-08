
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        depth = new int[N + 1];
        Arrays.fill(depth, -1);
        bfs(V);
        for (int i = 1; i <= N; i++) {
            System.out.println(depth[i]);
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        depth[v] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list[cur]) {
                if (depth[next] == -1) {
                    depth[next] = depth[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}