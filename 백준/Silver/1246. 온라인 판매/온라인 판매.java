
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[M];
        
   
        for(int i = 0; i < M ; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int Pi = 0; 
        int sum = 0; 
        
      
        for(int i = 0; i < M; i++) {
            int currentPrice = arr[i];
            
            int cus = M - i;
            
      
            int egg = Math.min(N, cus);
            
            
            int currentProfit = currentPrice * egg;
            

            if (currentProfit > sum) {
            	sum = currentProfit;
            	Pi = currentPrice;
            }
        }
        
    
        System.out.println(Pi + " " + sum);
    }
}