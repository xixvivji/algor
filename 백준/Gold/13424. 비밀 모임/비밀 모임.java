import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static ArrayList<Node>[] adj;
    static int[] friends, sum, dist;

    static class Node implements Comparable<Node> {
        int to, cost;
        Node(int to, int cost) { this.to = to; this.cost = cost; }
        public int compareTo(Node o) { return this.cost - o.cost; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj[a].add(new Node(b, c));
                adj[b].add(new Node(a, c));
            }
            K = Integer.parseInt(br.readLine());
            friends = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) friends[i] = Integer.parseInt(st.nextToken());

            sum = new int[N + 1];
            dist = new int[N + 1]; 

            for (int f = 0; f < K; f++) {
                Arrays.fill(dist, Integer.MAX_VALUE);
                dijkstra(friends[f]);
                for (int i = 1; i <= N; i++) {
                    sum[i] += dist[i];
                }
            }

            int answer = 1, minSum = sum[1];
            for (int i = 2; i <= N; i++) {
                if (sum[i] < minSum) {
                    minSum = sum[i];
                    answer = i;
                }
            }
            System.out.println(answer);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.cost) continue;
            for (Node next : adj[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}