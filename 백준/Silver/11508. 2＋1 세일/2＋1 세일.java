

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(prices);
        int sum = 0;
        int idx = N - 1;
        while (idx >= 0) {
            sum += prices[idx];
            idx--;
            if (idx >= 0) {
                sum += prices[idx];
                idx--;
            }
            if (idx >= 0) {
                idx--;
            }
        }
        System.out.println(sum);
    }
}