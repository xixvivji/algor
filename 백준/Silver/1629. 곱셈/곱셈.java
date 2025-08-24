import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(power(A, B, C));
    }
    
    
    static long power(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long temp = power(a, b / 2, c);
        if (b % 2 == 0) {
            return (temp * temp) % c;
        } else {
            return (temp * temp % c * a % c) % c;
        }
    }
}