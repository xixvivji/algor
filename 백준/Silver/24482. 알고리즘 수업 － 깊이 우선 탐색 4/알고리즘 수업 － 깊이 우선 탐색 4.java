

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int order[];

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
        order = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            list[i].sort(Collections.reverseOrder());
        }
        

        Arrays.fill(order, -1);
        dfs(V, 0);
        for (int i = 1; i <= N; i++) {
            if (order[i] == -1) {
                System.out.println(-1);
            } else {
                System.out.println(order[i]);
            }
        }
    }

    static void dfs(int v, int depth) {
        visited[v] = true;
        order[v] = depth;
        for (int n : list[v]) {
            if (!visited[n]) {
                dfs(n, depth + 1);
            }
        }
    }

}