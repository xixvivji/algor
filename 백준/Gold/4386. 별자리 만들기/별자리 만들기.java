import java.io.*;
import java.util.*;

public class Main {
    static class Star {
        double x, y;
        Star(double x, double y) {
            this.x = x; this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Star[] stars = new Star[N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            stars[i] = new Star(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
        }
        PrimMST mst = new PrimMST(stars);
        double answer = mst.getMSTLength();
        System.out.printf("%.2f\n", answer);
    }
}

class PrimMST {
    int N;
    Main.Star[] stars;
    boolean[] visited;

    public PrimMST(Main.Star[] stars) {
        this.N = stars.length;
        this.stars = stars;
        this.visited = new boolean[N];
    }

    public double getMSTLength() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0.0));
        double total = 0.0;
        int connected = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            total += cur.cost;
            connected++;
            if (connected == N) break;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    double dist = getDist(stars[cur.to], stars[i]);
                    pq.offer(new Node(i, dist));
                }
            }
        }
        return total;
    }

    static double getDist(Main.Star a, Main.Star b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static class Node implements Comparable<Node> {
        int to;
        double cost;
        Node(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }
}