import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int start = 1, end = 1;
        long sum = 1;
        int count = 0;

        while (start <= N) {
            if (sum == N) {
                count++;
                sum -= start;
                start++;
            } else if (sum < N) {
                end++;
                if (end > N) break;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}