import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        long[] arr = new long[n+1];
        long[] result = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= n; i++){
            
            arr[i] = arr[i-1] + Long.parseLong(st.nextToken());
        }
        
        for(int i= 1; i<= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            result[i-1] = arr[b] - arr[a-1]; 
            
        }
       for(int i = 0; i< m; i++){
        System.out.println(result[i]);
       }

    }
}