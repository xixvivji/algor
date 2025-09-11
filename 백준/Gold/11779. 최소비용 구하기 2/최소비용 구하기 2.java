import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node>[] list;
    static int[] dist, prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);

        List<Integer> path = new ArrayList<>();
        for (int cur = end; cur != 0; cur = prev[cur]) {
            path.add(cur);
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for (int v : path) {
            System.out.print(v + " ");
        }
    }

    static void dijkstra(int start) {
        dist = new int[N + 1];
        prev = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

        if (dist[cur.to] < cur.value) continue;
            for (Node next : list[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.value) {
                    dist[next.to] = dist[cur.to] + next.value;
                    prev[next.to] = cur.to;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to, value;

        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}