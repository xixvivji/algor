

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(int i = 0 ; i < s.length(); i++) {
        	if( i % 10 == 9) {
        		System.out.println(s.charAt(i));
        		
        	}else
        	System.out.print(s.charAt(i));
        	
        }
        
    }
}