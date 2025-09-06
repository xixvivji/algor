

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static boolean visited[];
    static ArrayList<Integer>[] list;
    static int[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];
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
            Collections.sort(list[i], Collections.reverseOrder());
        }

        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;
        visited[start] = true;
        order[start] = cnt++;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : list[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    order[next] = cnt++;
                    queue.add(next);
                }
            }
        }
    }
}