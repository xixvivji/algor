import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            System.out.print("Case #" + tc + ": ");
            if (arr[0] + arr[1] <= arr[2]) {
                System.out.println("invalid!");
            } else if (arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("equilateral");
            } else if (arr[0] == arr[1] || arr[1] == arr[2]) {
                System.out.println("isosceles");
            } else {
                System.out.println("scalene");
            }
        }
    }
}