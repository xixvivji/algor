import java.io.*;
import java.util.*;

public class Main {
    static int N,X,K;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int arr[] = new int[N+1];
        arr[X] = 1;
        
        for(int i =0; i < K; i++) {
        st =new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int temp = arr[a];
       arr[a] = arr[b];
       arr[b] = temp;
        }
    
    for(int i = 1; i<= N; i++) {
    	if(arr[i] ==1)
    		System.out.println(i);
    }
    }
}