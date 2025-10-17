import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int left = max, right = sum, answer = sum;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1, money = mid;
            for (int i = 0; i < N; i++) {
                if (money < arr[i]) {
                    cnt++;
                    money = mid;
                }
                money -= arr[i];
            }
            if (cnt > M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}