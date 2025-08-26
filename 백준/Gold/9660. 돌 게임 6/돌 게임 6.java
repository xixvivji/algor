
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class Main {
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        long n = Long.parseLong(br.readLine());
	        if(n>=5) {
	        	if(n-1 % 2== 0 || n-3 % 2 == 0|| n -4 % 2 ==0)
	        		n = 1;
	        }
	        

	        if(n % 7 == 0 || n % 7 == 2) {		
	        	System.out.println("CY");		
	        	}
	        else {
	        	System.out.println("SK");	
	        	}
	    
	    }
	}