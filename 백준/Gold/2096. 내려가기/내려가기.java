import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
     
        int arr[][] = new int [N][3];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < 3; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
            int[] preMax = arr[0].clone();
            int[] preMin = arr[0].clone();

            for (int i = 1; i < N; i++) {
                int[] curMax = new int[3];
                int[] curMin = new int[3];

                curMax[0] = arr[i][0] + Math.max(preMax[0], preMax[1]);
                curMax[1] = arr[i][1] + Math.max(Math.max(preMax[0], preMax[1]), preMax[2]);
                curMax[2] = arr[i][2] + Math.max(preMax[1], preMax[2]);

                curMin[0] = arr[i][0] + Math.min(preMin[0], preMin[1]);
                curMin[1] = arr[i][1] + Math.min(Math.min(preMin[0], preMin[1]), preMin[2]);
                curMin[2] = arr[i][2] + Math.min(preMin[1], preMin[2]);

                preMax = curMax;
                preMin = curMin;
            }

            int max = Math.max(Math.max(preMax[0], preMax[1]), preMax[2]);
            int min = Math.min(Math.min(preMin[0], preMin[1]), preMin[2]);
            System.out.println(max + " " + min);
        }
    }