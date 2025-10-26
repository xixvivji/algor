import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int N = 0;
        int res = 0;

        for (int h = 0; h < 24; h++) {
            if (N + A <= M) {
                N += A;
                res += B;
            } else {
                N -= C;
                if (N < 0) {
                    N = 0;
                }
            }
        }

        System.out.println(res);
    }
}