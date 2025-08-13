import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = -1;

        for (int height = min; height <= max; height++) {
            int t = 0;
            int block = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                   
                    if(arr[i][j] < height){
                        int diff = height - arr[i][j];
                        block -= diff;
                        t += diff;
                    }
                    
                    else if(arr[i][j] > height){
                        int diff = arr[i][j] - height;
                        block += diff;
                        t += 2 * diff;
                    }
                }
            }

            if(block >= 0){
                if(minTime >= t){
                    minTime = t;
                    maxHeight = height;
                }
            }
        }
        System.out.println(minTime + " " + maxHeight);
    }
}
