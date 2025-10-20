

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int res = 0;
        while(a != b) {
        	a = a / 2 + a % 2;
        	b = b / 2 + b % 2;
        	res ++;
        }
        
        System.out.println(res);
       
        
    }
}