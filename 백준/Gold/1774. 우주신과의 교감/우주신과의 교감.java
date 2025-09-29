import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Point[] gods;
    static boolean[] visited;
    static ArrayList<Edge>[] graph;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        double cost;

        Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gods = new Point[N + 1];
        visited = new boolean[N + 1];
        graph = (ArrayList<Edge>[]) new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            gods[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, 0));
            graph[b].add(new Edge(a, 0));
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dist = Math.sqrt(
                        Math.pow(gods[i].x - gods[j].x, 2) + Math.pow(gods[i].y - gods[j].y, 2));
                graph[i].add(new Edge(j, dist));
                graph[j].add(new Edge(i, dist));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        double answer = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;
            answer += cur.cost;
            cnt++;
            if (cnt == N) {
                break;
            }
            for (Edge next : graph[cur.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        System.out.printf("%.2f\n", answer);
    }
}