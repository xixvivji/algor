import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(cal(n, r, c));
    }

    static int cal(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        int half = (int) Math.pow(2, n - 1);

        int N = 0;
        if (r < half && c < half) {
            N = 0;
        } else if (r < half && c >= half) {
            N = 1;
            c -= half;
        } else if (r >= half && c < half) {
            N = 2;
            r -= half;
        } else {
            N = 3;
            r -= half;
            c -= half;
        }
        return N * half * half + cal(n - 1, r, c);
    }
}