
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visitedNoBreak, visitedBreak;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        visitedNoBreak = new boolean[N][M];
        visitedBreak = new boolean[N][M];
        q.offer(new Node(0, 0, 1, false));
        visitedNoBreak[0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x, y = now.y, dist = now.dist;
            boolean broken = now.broken;

            if (x == N - 1 && y == M - 1) 
            	return dist;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0) { 
                    if (!broken && !visitedNoBreak[nx][ny]) {
                        visitedNoBreak[nx][ny] = true;
                        q.offer(new Node(nx, ny, dist + 1, false));
                    }
                    
                    if (broken && !visitedBreak[nx][ny]) {
                        visitedBreak[nx][ny] = true;
                        q.offer(new Node(nx, ny, dist + 1, true));
                    }
                } else { 
                    if (!broken && !visitedBreak[nx][ny]) {
                        visitedBreak[nx][ny] = true;
                        q.offer(new Node(nx, ny, dist + 1, true));
                    }
                  
                }
            }
        }
        return -1;
    }

    static class Node {
        int x, y, dist;
        boolean broken;
        Node(int x, int y, int dist, boolean broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }
}