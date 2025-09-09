
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        PriorityQueue<node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        while (!pq.isEmpty()) {
            node cur = pq.poll();
            System.out.println(cur.x + " " + cur.y);
        }
    }

    static class node implements Comparable<node> {
        int x;
        int y;

        node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(node o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return x - o.x;
        }
    }
}