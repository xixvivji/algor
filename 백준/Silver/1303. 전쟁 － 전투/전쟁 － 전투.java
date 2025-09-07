
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int W = 0;
        int B = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'W' && !visited[i][j]) {
                    int size = dfs(i, j);
                    W += size * size;
                } else if (map[i][j] == 'B' && !visited[i][j]) {
                    int size = dfs(i, j);
                    B += size * size;
                }
            }
        }
        System.out.println(W + " " + B);
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }
            if (map[nx][ny] == map[x][y] && !visited[nx][ny]) {
                cnt += dfs(nx, ny);
            }
        }
        return cnt;
    }
}