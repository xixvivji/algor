

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxPrize = 0;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[7];
            int max = 0;
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[n]++;
                if (n > max) {
                    max = n;
                }
            }
            int res = 0;
            for (int k = 1; k <= 6; k++) {
                if (arr[k] == 4) {
                    res = 50000 + k * 5000;
                    break;
                } else if (arr[k] == 3) {
                    res = 10000 + k * 1000;
                    break;
                }
            }
            if (res == 0) {
                int pair = 0, first = 0, second = 0;
                for (int k = 1; k <= 6; k++) {
                    if (arr[k] == 2) {
                        pair++;
                        if (first == 0) {
                            first = k;
                        } else {
                            second = k;
                        }
                    }
                }
                if (pair == 2) {
                    res = 2000 + (first + second) * 500;
                } else if (pair == 1) {
                    res = 1000 + first * 100;
                } else {
                    res = max * 100;
                }
            }
            if (res > maxPrize) {
                maxPrize = res;
            }
        }
        System.out.println(maxPrize);
    }
}