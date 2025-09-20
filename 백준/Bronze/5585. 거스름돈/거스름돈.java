import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());
        int N = 1000 - val;


        int count = 0;
        count += N / 500;
        N %= 500;
        count += N / 100;
        N %= 100;
        count += N / 50;
        N %= 50;
        count += N / 10;
        N %= 10;
        count += N / 5;
        N %= 5;
        count += N;
        System.out.println(count);
    }
}