
import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int wallCnt) {
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<node> queue = new LinkedList<>();
        copyMap = new int[N][M];

     for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
        copyMap[i][j] = map[i][j];
    }
}

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyMap[i][j] == 2) {
                    queue.offer(new node(i, j));
                }
            }
        }

        while (!queue.isEmpty()){
            node n = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(0 <= nx && nx < N && 0<= ny && ny < M) {
                    if(copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        queue.offer(new node(nx, ny));
                    }
                }
            }
        }

        countZone(copyMap);
    }

    private static void countZone(int[][] copyMap) {
        int safeZone =0;
        for(int i=0; i<N ; i++) {
            for(int j=0; j<M; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        max = Math.max(safeZone, max);
    }
    
    static class node {
        int x, y;
        node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
}