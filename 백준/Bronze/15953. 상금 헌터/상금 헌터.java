
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int res = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if (a > 0) {
                if (a == 1) {
                    res += 500;
                } else if (a <= 3) {
                    res += 300;
                } else if (a <= 6) {
                    res += 200;
                } else if (a <= 10) {
                    res += 50;
                } else if (a <= 15) {
                    res += 30;
                } else if (a <= 21) {
                    res += 10;
                }
            }

            if (b > 0) {
                if (b == 1) {
                    res += 512;
                } else if (b <= 3) {
                    res += 256;
                } else if (b <= 7) {
                    res += 128;
                } else if (b <= 15) {
                    res += 64;
                } else if (b <= 31) {
                    res += 32;
                }
            }

            System.out.println(res * 10000);
        }
    }
}