
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i != j && cost != 0) { 
                    list[i].add(new Node(j, cost));
                }
            }
        }

        System.out.println(prim());
    }

    static long prim() {
        long count = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N];
        pq.add(new Node(0, 0));
        int vico = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            count += cur.value;
            vico++;
            if (vico == N) break;
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