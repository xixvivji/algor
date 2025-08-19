import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;

       
        for (int i = N - 1; i > 0; i--) {
         
            if (arr[i - 1] >= arr[i]) {
               
                int dif= arr[i - 1] - arr[i] + 1;
         
                sum += dif;
            
                arr[i - 1] -= dif;
            }
        }
        System.out.println(sum);
    }
}