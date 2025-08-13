import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int []arr = new int[N+3];
        int count = 0;
        for(int i = 2; i<= N; i++){
            arr[i] = i;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j+= i) {
                
                if(arr[j] !=0){
                    arr[j] = 0;
                    count ++;
                    if(count == M)
                    System.out.println(j);
                }

            }
        }

        

    
    }
}