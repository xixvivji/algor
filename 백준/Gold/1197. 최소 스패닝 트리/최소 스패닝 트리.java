import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w)); 
        }

        System.out.println(prim());
    }

    static int prim() {
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0)); 
        int result = 0, cnt = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            result += cur.value;
            cnt++;
            if (cnt == V) break;
            for (Node next : list[cur.to]) {
                if (!visited[next.to]) pq.add(next);
            }
        }
        return result;
    }

    static class Node implements Comparable<Node> {
        int to, value;
        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}