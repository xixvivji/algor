import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static ArrayList<Node>[] list;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] == 1) {
            System.out.println(-1);
            return;
        }

        list = new ArrayList[N];
        dist = new long[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0] = 0L;
        pq.add(new Node(0, 0L));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.cost) {
                continue;
            }
            for (Node next : list[cur.to]) {
                if (next.to != N - 1 && arr[next.to] == 1) {
                    continue;
                }
                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    if (next.to != N - 1) {
                        pq.add(new Node(next.to, dist[next.to]));
                    }
                }
            }
        }

        System.out.println(dist[N - 1] == Long.MAX_VALUE ? -1 : dist[N - 1]);
    }

    static class Node implements Comparable<Node> {
        int to;
        long cost;

        Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}