import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = getMin(arr, N, M);
        System.out.println(min - 1);
    }

    private static int getMin(int[] arr, int N, int M) {
        int min = 1;
        int max = arr[N - 1] - arr[0] + 1;
        while (min <= max) {
            int ans = (min + max) / 2;
            int count = 1;
            int last = arr[0];
            for (int i = 1; i < N; i++) {
                if (arr[i] - last >= ans) {
                    count++;
                    last = arr[i];
                }
            }
            if (count >= M) {
                min = ans + 1;
            } else {
                max = ans - 1;
            }
            
        }
        return min;
    }
}