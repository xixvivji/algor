import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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
            list[b].add(new Node(a, c));

        }

        bfs(1, N);
        System.out.println(dist[N]);
    }

    static void bfs(int start, int end) {
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.to == end) {
                break;
            }
            if (dist[cur.to] < cur.val) {
                continue;
            }
            for (Node next : list[cur.to]) {
                if (dist[next.to] > next.val + dist[cur.to]) {
                    dist[next.to] = next.val + dist[cur.to];
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }

        }
    }

    static class Node implements Comparable<Node> {
        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }

        int to;
        int val;

        Node(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }
}