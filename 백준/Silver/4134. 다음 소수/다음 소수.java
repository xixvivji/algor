
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long i = n;
            while (true) {
                if (isPrime(i)) {
                    sb.append(i).append('\n');
                    break;
                }
                i++;
            }
        }

        System.out.print(sb.toString());
    }

    private static boolean isPrime(long x) {
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        long r = (long) Math.sqrt(x);
        for (long j = 3; j <= r; j += 2) {
            if (x % j == 0) return false;
        }
        return true;
    }
}