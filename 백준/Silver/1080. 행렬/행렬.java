

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] brr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                brr[i][j] = s.charAt(j) - '0';
            }
        }
        int count = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (arr[i][j] != brr[i][j]) {

                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            arr[x][y] = arr[x][y] == 0 ? 1 : 0;
                        }
                    }
                    count++;
                }
            }
        }

        boolean same = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != brr[i][j]) {
                    same = false;
                    break;
                }
            }
        }

        System.out.println(same ? count : -1);
    }
}