import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int s, e;
    static ArrayList<Node>[] list;
    static int dist[];

    static class Node implements Comparable<Node> {
        int to;
        int value;

        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }


        public int compareTo(Node o) {
            return o.value - this.value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

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
        dijk(s);

     if (dist[e] == Integer.MIN_VALUE) System.out.println(0);
        else System.out.println(dist[e]);
    }
    
    static void dijk(int start) {
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[start] = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, Integer.MAX_VALUE));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] > cur.value) continue;
            for (Node next : list[cur.to]) {
                int res = Math.min(dist[cur.to], next.value);
                if (dist[next.to] < res) {
                    dist[next.to] = res;
                    pq.add(new Node(next.to, res));
                }
            }
        }
    }
}