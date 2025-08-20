
import java.io.*;
import java.util.*;

public class Main {
		
	    public static void main(String[] args) throws Exception {
	    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    		StringTokenizer st;
	    		st = new StringTokenizer(br.readLine());
	    		int K = Integer.parseInt(st.nextToken());
	    		int N = Integer.parseInt(st.nextToken());
	    		long max = 0;
	    		int[] arr =new int [K];
	    		for(int i = 0; i< arr.length; i++) {
	    			arr[i] = Integer.parseInt(br.readLine());	    			
	    		if(max < arr[i])
	    		max = arr[i];
	    		}
	    		
	    		
	    		long min = 0;
	    		long mid = 0;
	    		max++;

	    		
	    		while (min < max) { 
	    			
	    
	    			mid = (max + min) / 2;
	    			
	     
	    			long count = 0;
	    			
	    		
	     
	    			for (int i = 0; i < arr.length; i++) {
	    				count += (arr[i] / mid);
	    			}
	    	
	    			
	    			if(count < N) {
	    				max = mid;
	    			}
	    			else {
	    				min = mid + 1;
	    			}
	    			
	     
	    		}
	    		
	    		System.out.println(min -1);
	   }
	    
}