import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {

                break;
            }
            String reversed = new StringBuilder(String.valueOf(n)).reverse().toString();
            if (n == Integer.parseInt(reversed)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}