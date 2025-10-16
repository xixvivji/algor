import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int arr[] = new int[26];
       Arrays.fill(arr, 0);
       String s= br.readLine();
       
       for(int i = 0 ; i < s.length(); i++) {
    	   arr[s.charAt(i) -'a'] += 1;
       }
       
       for(int i = 0; i < arr.length; i++) {
    	   System.out.print(arr[i] + " ");
       }
        
    }
}