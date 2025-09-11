import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] list;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N+1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }
        if (bellmanFord(1)) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) System.out.println(-1);
                else System.out.println(dist[i]);
            }
        } else {
            System.out.println(-1); // 음수 사이클 존재
        }
    }
    // true: 음수 사이클 없음, false: 있음
    static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 1; i < N; i++) { // N-1번 반복
            for (int u = 1; u <= N; u++) {
                for (Node node : list[u]) {
                    if (dist[u] != INF && dist[node.to] > dist[u] + node.value) {
                        dist[node.to] = dist[u] + node.value;
                    }
                }
            }
        }

        // 음수 사이클 체크
        for (int u = 1; u <= N; u++) {
            for (Node node : list[u]) {
                if (dist[u] != INF && dist[node.to] > dist[u] + node.value) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Node {
        int to, value;
        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}