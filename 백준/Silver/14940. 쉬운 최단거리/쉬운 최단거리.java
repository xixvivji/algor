import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] result;
    static int startX, startY;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[N][M];
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    startX = i;
                    startY = j;
                } else if (arr[i][j] == 1) {
                    result[i][j] = -1;
                }
            }
        }
        bfs(startX, startY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int x, int y) {
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(x, y));
        result[x][y] = 0;
        while (!queue.isEmpty()) {
            node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && result[nx][ny] == -1) {
                    result[nx][ny] = result[current.x][current.y] + 1;
                    queue.add(new node(nx, ny));
                }
            }
        }
    }

    static class node {
        int x;
        int y;


        public node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}