import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	}
        int m = Integer.parseInt(br.readLine());
        

        for (int i = 0; i < n; i += n / m) {
            int end = Math.min(i + n / m, n);
            Arrays.sort(arr, i, end);
        }
        
  
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}