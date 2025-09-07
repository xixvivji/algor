

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static int K;
    static ArrayList<node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new node(b, c));
        }
        bfs(K);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static void bfs(int start) {
        PriorityQueue<node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new node(start, 0));
        while (!pq.isEmpty()) {
            node cur = pq.poll();
            int now = cur.to;
            int nowWeight = cur.value;

            if (dist[now] < nowWeight) {
                continue;
            }

            for (node next : list[now]) {
                int cost = dist[now] + next.value;
                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    pq.add(new node(next.to, cost));
                }
            }
        }

    }


    static class node implements Comparable<node> {
        @Override
        public int compareTo(node o) {
            return value - o.value;
        }

        int to;
        int value;

        node(int to, int value) {

            this.to = to;
            this.value = value;
        }
    }
}