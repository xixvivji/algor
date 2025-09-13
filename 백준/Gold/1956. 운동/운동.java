
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static ArrayList<Node>[] list;
    static int[] dist;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, value));
        }

        int answer = INF;

      
        for (int i = 1; i <= V; i++) {
            dijkstra(i);

            for (int j = 1; j <= V; j++) {
                if (i == j) continue;
                for (Node node : list[j]) {
                    if (node.to == i && dist[j] != INF) {
                        answer = Math.min(answer, dist[j] + node.value);
                    }
                }
            }
        }

        System.out.println(answer == INF ? -1 : answer);
    }

    static void dijkstra(int start) {
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.value) continue;
            for (Node next : list[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.value) {
                    dist[next.to] = dist[cur.to] + next.value;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int value;

        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}