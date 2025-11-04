
import java.io.*;
import java.util.*;

public class Main {
   
	static int arr[][];
	
    public static void main(String[] args) throws IOException,NoSuchElementException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        
        arr = new int[4][8];
        for(int i = 0; i < 4; i++) {
        	String line = br.readLine();
        	for(int j = 0 ; j < 8; j++) {
        		arr[i][j] = line.charAt(j) - '0';
        	}
        }
        
        
        int K = Integer.parseInt(br.readLine());
       
        for(int d = 0 ; d < K; d++) {
        	st = new StringTokenizer(br.readLine());
        	int g = Integer.parseInt(st.nextToken())-1;
        	int dir = Integer.parseInt(st.nextToken());
        	
        	int turn[] = new int[4];
        	turn[g] = dir;
        
        	 for (int i = g; i > 0; i--) {
                 if (arr[i][6] != arr[i-1][2]) turn[i-1] = -turn[i];
                 else break;
             }

             for (int i = g; i < 3; i++) {
                 if (arr[i][2] != arr[i+1][6]) turn[i+1] = -turn[i];
                 else break;
             }
             

             for (int i = 0; i < 4; i++) {
                 if (turn[i] == 1) {
                     int tmp = arr[i][7];
                     for (int p = 7; p >= 1; p--) {
                         arr[i][p] = arr[i][p-1];
                     }
                     arr[i][0] = tmp;
                 } else if (turn[i] == -1) {
                     int tmp = arr[i][0];
                     for (int p = 0; p <= 6; p++) {
                         arr[i][p] = arr[i][p+1];
                     }
                     arr[i][7] = tmp;
                     
                 }
             }
         }
        

        int score = arr[0][0]*1 + arr[1][0]*2 + arr[2][0]*4 + arr[3][0]*8;
        System.out.println(score);
    }
}