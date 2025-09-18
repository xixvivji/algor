

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static ArrayList<Edge>[] graph;
    static long[][] dist;
    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        long ans = dijk(1, N, K);
        System.out.println(ans);
    }

    static long dijk(int start, int end, int K) {
        dist = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[start][0] = 0L;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(start, 0, 0L));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int v = cur.v;
            int used = cur.used;
            long cost = cur.cost;

            if (cost != dist[v][used]) {
                continue;
            }
            if (v == end) {
                return cost;
            }

            for (Edge e : graph[v]) {
                int u = e.to;
                long w = e.w;

                if (dist[u][used] > cost + w) {
                    dist[u][used] = cost + w;
                    pq.add(new State(u, used, dist[u][used]));
                }


                if (used < K && dist[u][used + 1] > cost) {
                    dist[u][used + 1] = cost;
                    pq.add(new State(u, used + 1, cost));
                }
            }
        }


        return dist[N][K];
    }

    static class Edge {
        int to;
        long w;

        Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    static class State implements Comparable<State> {
        int v, used;
        long cost;

        State(int v, int used, long cost) {
            this.v = v;
            this.used = used;
            this.cost = cost;
        }

        public int compareTo(State o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}