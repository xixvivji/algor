import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int N, M;
    static char[][] arr; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        int startX = 0, startY = 0; 

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'I') { 
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY); 

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        if (arr[i][j] == 'P') { 
            count++;
        }

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (arr[nx][ny] != 'X' && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}