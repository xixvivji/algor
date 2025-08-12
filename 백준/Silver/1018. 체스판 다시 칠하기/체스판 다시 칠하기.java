
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minCount = 64;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minCount = Math.min(minCount, countRepaints(board, i, j));
            }
        }
        System.out.println(minCount);
    }
    
    private static int countRepaints(char[][] board, int startX, int startY) {
        int count1 = 0; 
        int count2 = 0; 

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedChar1 = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedChar2 = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (board[startX + i][startY + j] != expectedChar1) {
                    count1++;
                }
                if (board[startX + i][startY + j] != expectedChar2) {
                    count2++;
                }
            }
        }
        return Math.min(count1, count2);
    }
}