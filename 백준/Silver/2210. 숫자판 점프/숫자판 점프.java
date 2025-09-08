
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[5][5];
    static Set<String> set = new HashSet<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, String.valueOf(map[i][j]));
            }
        }
        System.out.println(set.size());
    }

    static void dfs(int x, int y, int depth, String num) {
        if (depth == 5) {
            set.add(num);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            dfs(nx, ny, depth + 1, num + map[nx][ny]);
        }
    }
}