import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[] fact, inv;

    static long pow(long a, long b) {
        long result = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) result = (result * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }

    static void prepare(int n) {
        fact = new long[n + 1];
        inv = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = (fact[i - 1] * i) % MOD;
        inv[n] = pow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) inv[i] = (inv[i + 1] * (i + 1)) % MOD;
    }

    static long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * inv[k] % MOD * inv[n - k] % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        prepare(n);
        System.out.println(comb(n, k));
    }
}