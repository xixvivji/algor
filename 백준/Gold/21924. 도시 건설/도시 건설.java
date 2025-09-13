
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long N, M;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        list = new ArrayList[(int)(N + 1)];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        long total = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            total += value;
            list[to].add(new Node(from, value));
            list[from].add(new Node(to, value));
        }
        long mstCost = prim();
        if (mstCost == -1) {
            System.out.println(-1);
        } else {
            System.out.println(total - mstCost);
        }
    }

    static long prim() {
        int visitCount = 0;
        visited = new boolean[(int) (N + 1)];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        long count = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[(int) cur.to]) continue;
            visited[(int) cur.to] = true;
            count += cur.value;
            visitCount++;

            for (Node next : list[(int) cur.to]) {
                if (!visited[(int) next.to]) {
                    pq.add(new Node(next.to, next.value));
                }
            }
        }
        if (visitCount == N) return count;
        else return -1;
    }

    static class Node implements Comparable<Node> {
        long to, value;
        Node(long to, long value) {
            this.to = to;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.value, o.value);
        }
    }
}