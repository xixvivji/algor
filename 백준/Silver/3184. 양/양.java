
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int sheep = 0, wolf = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && (map[i][j] == 'o' || map[i][j] == 'v')) {
                    int[] arr = bfs(i, j);
                    if (arr[0] > arr[1]) {
                        sheep += arr[0];
                    } else {
                        wolf += arr[1];
                    }
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    static int[] bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[] {x, y});
        int s = 0, w = 0;
        if (map[x][y] == 'o') {
            s++;
        }
        if (map[x][y] == 'v') {
            w++;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == '#') {
                    continue;
                }
                visited[nx][ny] = true;
                if (map[nx][ny] == 'o') {
                    s++;
                }
                if (map[nx][ny] == 'v') {
                    w++;
                }
                q.add(new int[] {nx, ny});
            }
        }
        return new int[] {s, w};
    }
}