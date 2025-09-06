
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pq.add(new node(i, j, map[i][j]));
            }
        }
        node n = null;
        for (int i = 0; i < N; i++) {
            n = pq.poll();
        }
        System.out.println(n.value);

    }

    static class node implements Comparable<node> {
        int x;
        int y;
        int value;

        node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;

        }


        @Override
        public int compareTo(node o) {
            return o.value - value;
        }
    }
}