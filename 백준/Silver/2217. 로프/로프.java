import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Integer []arr = new Integer[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int max = 0;
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i = 0; i< N; i++){
            int sum = arr[i] * (i+1);
            max = Math.max(max, sum);
        }
        System.out.println(max);


	}
}