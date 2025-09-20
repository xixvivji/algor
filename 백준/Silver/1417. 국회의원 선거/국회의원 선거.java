import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        while (true) {
            int maxIdx = 2;
            for (int i = 3; i <= N; i++) {
                if (arr[i] > arr[maxIdx]) {
                    maxIdx = i;
                }
            }
            if (N == 1 || arr[1] > arr[maxIdx]) {
                break;
            }
            arr[1]++;
            arr[maxIdx]--;
            count++;
        }
        System.out.println(count);
    }
}