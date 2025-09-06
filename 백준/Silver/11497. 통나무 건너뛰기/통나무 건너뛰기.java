import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            
            int[] res = new int[N];
            int left = 0, right = N - 1;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    res[left++] = arr[i];
                } else {
                    res[right--] = arr[i];
                }
            }

            int max = Math.abs(res[0] - res[N - 1]);
            for (int i = 1; i < N; i++) {
                max = Math.max(max, Math.abs(res[i] - res[i - 1]));
            }
            System.out.println(max);
        }
    }
}