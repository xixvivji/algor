
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int left = 0;
        int max = 0;
        int kind = 0;

        for (int right = 0; right < N; right++) {
            if (count[arr[right]] == 0) {
                kind++; 
            }
            count[arr[right]]++;
            
            while (kind > 2) {
                count[arr[left]]--;
                if (count[arr[left]] == 0) {
                    kind--; 
                }
                left++; 
            }

    
            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}