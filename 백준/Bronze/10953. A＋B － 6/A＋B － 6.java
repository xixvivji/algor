import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        int arr[] =new int [2];
        int res = 0;
        for(int j =0 ; j< 2; j++) {
        	arr[j] = Integer.parseInt(st.nextToken());
        	res += arr[j];
        }
        System.out.println(res);
        }
        
        
        
        
    }
}