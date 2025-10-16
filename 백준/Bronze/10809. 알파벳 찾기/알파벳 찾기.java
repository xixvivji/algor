
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr= new int [26];
        Arrays.fill(arr, -1);
        String s = br.readLine();
       
        for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
    
			if(arr[ch - 'a'] == -1) {
				arr[ch - 'a'] = i;
			}
		}
 
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
}