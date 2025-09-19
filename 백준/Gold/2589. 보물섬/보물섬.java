

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        System.out.println(answer);
    }

    static int bfs(int sx, int sy) {
        boolean[][] visited = new boolean[R][C];
        Queue<Node> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.add(new Node(sx, sy, 0));

        int far = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            far = Math.max(far, cur.d);
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != 'L') continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny, cur.d + 1));
            }
        }
        return far;
    }
    
    static class Node {
        int x, y, d;
        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}