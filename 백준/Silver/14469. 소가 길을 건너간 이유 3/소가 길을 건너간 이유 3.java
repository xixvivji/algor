import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        
        for(int i = 0 ; i< N; i++) {
            st= new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        


        Arrays.sort(arr, (a1, a2) -> {
            return a1[0] - a2[0];
        });
        

        int cur = 0; 
        
        for(int i = 0; i < N; i++) {
            int a1 = arr[i][0];
            int a2 = arr[i][1];
            
         
            if (cur < a1) {
            
            	cur = a1; 
            }
            
         
            cur += a2; 
        }
        
        System.out.println(cur); 
    }
}