
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int N;
    static char[][] normalMap;
    static char[][] weakMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        normalMap = new char[N][N];
        weakMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                normalMap[i][j] = c;
                if (c == 'R') {
                    weakMap[i][j] = 'G';
                } else {
                    weakMap[i][j] = c;
                }
            }
        }

        // 일반인
        visited = new boolean[N][N];
        int normalCount = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited[x][y]) {
                    dfs(x, y, normalMap, normalMap[x][y]);
                    normalCount++;
                }
            }
        }

        // 적록색약
        visited = new boolean[N][N];
        int weakCount = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited[x][y]) {
                    dfs(x, y, weakMap, weakMap[x][y]);
                    weakCount++;
                }
            }
        }

        System.out.println(normalCount + " " + weakCount);
    }

    static void dfs(int x, int y, char[][] map, char color) {
        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == color) {
                    dfs(nx, ny, map, color);
                }
            }
        }
    }
}