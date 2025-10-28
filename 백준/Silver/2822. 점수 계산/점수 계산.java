
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] scores = new int[8][2]; 

        for (int i = 0; i < 8; i++) {
            scores[i][0] = Integer.parseInt(br.readLine()); 
            scores[i][1] = i + 1;
        }

       
        Arrays.sort(scores, (a, b) -> b[0] - a[0]);

        int sum = 0;
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
        	sum += scores[i][0];    
        	arr[i] = scores[i][1];  
        }

       
        Arrays.sort(arr);


        System.out.println(sum);

    
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }
}