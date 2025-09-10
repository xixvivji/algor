import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0, ans3 = 0;

        for (int i = 0; i < N - 2; i++) {
            int start = i + 1, end = N - 1;
            while (start < end) {
                long sum = arr[i] + arr[start] + arr[end];
                long abs = Math.abs(sum);
                if (abs < min) {
                    min = abs;
                    ans1 = arr[i];
                    ans2 = arr[start];
                    ans3 = arr[end];
                }
                if (sum < 0) start++;
                else end--;
            }
        }
        System.out.println(ans1 + " " + ans2 + " " + ans3);
    }
}