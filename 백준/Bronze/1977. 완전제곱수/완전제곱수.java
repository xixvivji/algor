
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= M; i++) {
            int j = i * i;
            if (j >= N && j <= M) {
                sum += j;
                if (min == Integer.MAX_VALUE) {
                    min = j;
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}