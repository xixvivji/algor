import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (start <= end) {
            if (sum >= S) {
                min = Math.min(min, end - start);
                sum -= arr[start++];
            } else if (end < N) {
                sum += arr[end++];
            } else {
                break;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}