import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        if (n <= 1) {
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        int g = 0;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            g = gcd(g, diff);
        }
        int total = (arr[n - 1] - arr[0]) / g;
        int result = total - (n - 1);
        System.out.println(result);
    }

    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}