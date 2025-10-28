import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); 
        
        int cnt = 0;
        int start = 0;
        int end = N - 1;
        
       
        while(start < end) {
            int sum = arr[start] + arr[end]; 
            
            if(sum == M) {
             
                cnt++;
                start++; 
                end--;   
            } else if (sum < M) {
             
                start++;
            } else { 
             
                end--;
            }
        }
        
      
        System.out.println(cnt);
    }
}