import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node>[] lists;
    static int[] parent, dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        dijkstra(1);

        StringBuilder sb = new StringBuilder();
        sb.append(N - 1).append('\n');
        for (int i = 2; i <= N; i++) {
            sb.append(i).append(' ').append(parent[i]).append('\n');
        }
        System.out.print(sb.toString());
    }

    static void dijkstra(int start) {
        dist = new int[N + 1];
        parent = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        parent[start] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist != dist[cur.u]) {
                continue;
            }

            for (Node e : lists[cur.u]) {
                int v = e.to;
                int nd = cur.dist + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    parent[v] = cur.u;
                    pq.add(new State(v, nd));
                }
            }
        }
    }

    static class Node {
        int to, w;

        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class State implements Comparable<State> {
        int u, dist;

        State(int u, int dist) {
            this.u = u;
            this.dist = dist;
        }

        public int compareTo(State o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}