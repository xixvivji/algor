
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] up = new int[n+1];   
        int[] down = new int[n+1];  
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            up[i] = 1;
            down[i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
            }
        }

        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                if (arr[j] < arr[i]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, up[i] + down[i] - 1); 
        }
        System.out.println(ans);
    }
}