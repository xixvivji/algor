

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node>[] list;
    static int[] dist;
    static int[] P, Q; 

    static class Node implements Comparable<Node> {
        int to;
        int value;

        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
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

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        P = new int[p];
        Q = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            Q[i] = Integer.parseInt(st.nextToken());
        }

        dist = new int[N + 1];
        dijk();

        int answer = -1, minDist = Integer.MAX_VALUE;
        for (int i = 0; i < p; i++) {
            int house = P[i];
            if (dist[house] < minDist) {
                minDist = dist[house];
                answer = house;
            } else if (dist[house] == minDist && house < answer) {
                answer = house;
            }
        }
        System.out.println(answer);
    }

    static void dijk() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int mart : Q) {
            dist[mart] = 0;
            pq.add(new Node(mart, 0));
        }
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.value) {
                continue;
            }
            for (Node next : list[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.value) {
                    dist[next.to] = dist[cur.to] + next.value;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}