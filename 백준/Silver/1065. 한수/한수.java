
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 100) {
            System.out.println(N);
            return;
        }
        int count = 99;

        for (int i = 100; i <= N; i++) {

            int hundreds = i / 100;
            int tens = (i / 10) % 10;
            int ones = i % 10;

            if ((hundreds - tens) == (tens - ones)) {
                count++;
            }
        }

        System.out.println(count);

    }
}