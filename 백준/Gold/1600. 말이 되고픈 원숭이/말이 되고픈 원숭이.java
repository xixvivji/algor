

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] hm = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[H][W][K + 1];
        q.add(new Node(0, 0, K, 0));
        visited[0][0][K] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.x == H - 1 && n.y == W - 1) {
                return n.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < H && ny < W && arr[nx][ny] == 0 &&
                        !visited[nx][ny][n.k]) {
                    visited[nx][ny][n.k] = true;
                    q.add(new Node(nx, ny, n.k, n.cnt + 1));
                }
            }

            if (n.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = n.x + hm[i][0];
                    int ny = n.y + hm[i][1];
                    if (nx >= 0 && ny >= 0 && nx < H && ny < W && arr[nx][ny] == 0 &&
                            !visited[nx][ny][n.k - 1]) {
                        visited[nx][ny][n.k - 1] = true;
                        q.add(new Node(nx, ny, n.k - 1, n.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int x, y, k, cnt;

        Node(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}