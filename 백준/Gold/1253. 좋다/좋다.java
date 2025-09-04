
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for (int k = 0; k < N; k++) {
            int left = 0, right = N - 1;
            while (left < right) {
                if (left == k) {
                    left++;
                    continue;
                }
                if (right == k) {
                    right--;
                    continue;
                }
                int sum = arr[left] + arr[right];
                if (sum == arr[k]) {
                    count++;
                    break;
                } else if (sum < arr[k]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(count);
    }
}