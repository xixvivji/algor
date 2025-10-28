
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 0 ; tc < N; tc++) {
        	int arr[] =  new int [10];
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0 ; i < 10; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        		
        	}
        	Arrays.sort(arr);
        
        	sb.append(arr[7]).append("\n");	
        	
        }
        System.out.println(sb.toString());
        
        
    }
}