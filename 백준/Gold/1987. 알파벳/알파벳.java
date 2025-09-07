

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[] alphaVisited = new boolean[26];
    static int maxCount = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];
        
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        dfs(0, 0, 1);
        System.out.println(maxCount);
    }

    static void dfs(int x, int y, int cnt) {
        alphaVisited[map[x][y] - 'A'] = true;
        maxCount = Math.max(maxCount, cnt);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }
            if (!alphaVisited[map[nx][ny] - 'A']) {
                dfs(nx, ny, cnt + 1);
            }
        }
        alphaVisited[map[x][y] - 'A'] = false;
    }
}