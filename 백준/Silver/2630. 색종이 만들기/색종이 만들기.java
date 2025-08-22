import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

    static int[][] paper;
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
    
    public static void dfs(int row, int col, int size) {
        if (isColorSame(row, col, size)) {
            if (paper[row][col] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return; 
        }
        int newSize = size / 2;

        dfs(row, col, newSize);
        dfs(row, col + newSize, newSize);
        dfs(row + newSize, col, newSize);
        dfs(row + newSize, col + newSize, newSize);
    }

 
    public static boolean isColorSame(int row, int col, int size) {
        int color = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}