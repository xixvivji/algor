import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());	
        }
        Arrays.sort(arr);
        
        int start = 0;
        int end =N-1;
           int min =Integer.MAX_VALUE;

        int arr1 = 0;
        int arr2 = 0;
        	while(start < end) {
        		int sum = arr[start] + arr[end];
        		int abs = Math.abs(sum);
        		if(abs < min) {
        			min = abs;
        		arr1 = arr[start];
        		arr2 = arr[end];
        		}
        		if(sum < 0) start++;
        		else end--;
        		
        	}
        	System.out.println(arr1 + " " + arr2);
        
    }
}