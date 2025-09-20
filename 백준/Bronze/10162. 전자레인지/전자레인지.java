
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a = 0, b = 0, c = 0;
        if (N % 10 != 0) {
            System.out.println(-1);
        } else {
            a = N / 300;
            N %= 300;
            b = N / 60;
            N %= 60;
            c = N / 10;
            System.out.println(a + " " + b + " " + c);
        }
    }
}