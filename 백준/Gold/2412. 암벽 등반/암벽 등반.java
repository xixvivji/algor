import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] rocks = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rocks[i][0] = Integer.parseInt(st.nextToken());
            rocks[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rocks, Comparator.comparingInt(a -> a[1]));

        boolean[] visited = new boolean[N];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == T) {
                System.out.println(cur.cnt);
                return;
            }
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    int nx = rocks[i][0], ny = rocks[i][1];
                    if (Math.abs(cur.x - nx) <= 2 && Math.abs(cur.y - ny) <= 2) {
                        visited[i] = true;
                        q.add(new Node(nx, ny, cur.cnt + 1));
                    } else if (ny > cur.y + 2) {
                        break;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Node {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}