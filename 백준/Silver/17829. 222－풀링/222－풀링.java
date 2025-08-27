
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (N > 1) {
            arr = pooling(arr, N);
            N /= 2;
        }
        System.out.println(arr[0][0]);
    }


    public static int[][] pooling(int[][] a, int size) {
        int[][] next = new int[size / 2][size / 2];
        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < size; j += 2) {
                int[] temp = new int[4];
                temp[0] = a[i][j];
                temp[1] = a[i][j + 1];
                temp[2] = a[i + 1][j];
                temp[3] = a[i + 1][j + 1];
                Arrays.sort(temp);
                next[i / 2][j / 2] = temp[2]; 
            }
        }
        return next;
    }
}