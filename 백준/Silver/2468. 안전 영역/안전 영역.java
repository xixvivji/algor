import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[][];
    static boolean visited[][];
    static int count = 0;
    static int[] result;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        visited = new boolean[N][N];
        arr = new int[N][N];
        result = new int [N];
 int maxHeight = 0;
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

         int Max = 1;
      for (int h = 1; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > h) {
                        dfs(i, j, h);
                        count++;
                    }
                }
            }
            Max = Math.max(Max, count);
        }
        System.out.println(Max);
    }


    static void dfs(int i, int j, int n){
        visited[i][j] = true;
        for(int a = 0; a < 4; a++){
            int nx = i + dx[a];
            int ny = j + dy[a];
            if(nx>= 0 && nx < N && ny>= 0&& ny < N ){
                if (!visited[nx][ny] && arr[nx][ny] > n) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, n);
                }

            }
        }
      
       
    }


}