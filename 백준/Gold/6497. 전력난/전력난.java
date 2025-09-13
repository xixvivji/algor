import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            list = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
            visited = new boolean[N];

            int total = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                total += value;
                list[from].add(new Node(to, value));
                list[to].add(new Node(from, value));
            }

            System.out.println(total - prim());
        }
    }

    static int prim() {
        int count = 0;
        int visitCount = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            count += cur.value;
            visitCount++;

            if (visitCount == N) break;

            for (Node next : list[cur.to]) {
                if (!visited[next.to]) {
                    pq.add(new Node(next.to, next.value));
                }
            }
        }

        return count;
    }

    static class Node implements Comparable<Node> {
        int to, value;
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