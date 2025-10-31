import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long result = 0L;

        result += N;

        for (int i = 0; i < N; i++) {
            long l = A[i] - B;
            if (l > 0) {
                result += (l + C - 1) / C;
            }
        }

        System.out.println(result);
    }
}