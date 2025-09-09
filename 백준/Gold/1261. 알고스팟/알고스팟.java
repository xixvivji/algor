import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        map = new int[M][N];
        dist = new int[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(dist[M-1][N-1]);
    }

    static void bfs() {
        Deque<Node> dq = new LinkedList<>();
        dist[0][0] = 0;
        dq.add(new Node(0, 0));

        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                int nextDist = dist[cur.x][cur.y] + map[nx][ny];
                if (dist[nx][ny] > nextDist) {
                    dist[nx][ny] = nextDist;
                    if (map[nx][ny] == 0) {
                        dq.addFirst(new Node(nx, ny)); 
                    } else {
                        dq.addLast(new Node(nx, ny)); 
                    }
                }
            }
        }
    }

    static class Node {
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}