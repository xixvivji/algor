import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N <= 2) {
            System.out.println(0);
            return;
        }
        
       /* int pairs = N / 2;
        int minS = Integer.MAX_VALUE;
        int maxS = Integer.MIN_VALUE;
        for (int i = 0; i < pairs; i++) {
            int s = arr[i] + arr[N - 1 - i];
            if (s < minS) minS = s;
            if (s > maxS) maxS = s;
        }
       
        if (maxS - minS > 4) {
            System.out.println(-1);
            return;
        }*/
       
        int res = Integer.MAX_VALUE;

      
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                long arr0 = arr[0] + dx;
                long arr1 = arr[1] + dy;
                long diff1 = arr1 - arr0;

                int ops = Math.abs(dx) + Math.abs(dy);
                boolean can  = true;
                long expect = arr1;
               
                for (int k = 2; k < N; k++) {
                    expect += diff1; 
                    long cur = arr[k];
                    long diff2 = Math.abs(cur - expect);
                    if (diff2 > 1) {
                        can = false;
                        break;
                    } else {
                        ops += (int) diff2;
                    }
                }
                if (can) {
                	res = Math.min(res, ops);
                }
            }
        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}