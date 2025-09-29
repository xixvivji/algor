

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] map;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N + 2][M + 2];
        dist = new int[N + 2][M + 2];
        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x, y = cur.y;

            for (int dir = 0; dir < 4; dir++) {
                for (int step = 1; step <= K; step++) {
                    int nx = x + dx[dir] * step;
                    int ny = y + dy[dir] * step;

                    if (nx < 1 || ny < 1 || nx > N || ny > M) {
                        break;
                    }
                    if (map[nx][ny] == '#') {
                        break;
                    }
                    if (dist[nx][ny] != -1 && dist[nx][ny] <= dist[x][y]) {
                        break;
                    }

                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }

        System.out.println(dist[ex][ey]);
    }
}