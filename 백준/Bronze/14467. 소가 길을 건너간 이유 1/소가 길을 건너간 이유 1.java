
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int [][] arr= new int [11][1];
        for(int i = 0; i <=10  ;i++) {
        	arr[i][0] = -1;
        }
        
        int res = 0;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	if(arr[a][0] == -1) {
        		arr[a][0] = b;
        		
        	}
        	else if(arr[a][0] != b) {
        		res++;
        		arr[a][0] = b;
        	}
        	
        }
     System.out.println(res);
    }
}