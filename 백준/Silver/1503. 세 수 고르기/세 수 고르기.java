import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[1002];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                arr[x] = 1;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 1000; i++) {
            if (arr[i] == 1) {
                continue;
            }
            for (int j = i; j <= 1000; j++) {
                if (arr[j] == 1) {
                    continue;
                }
                for (int k = j; k <= 1001; k++) {
                    if (arr[k] == 1) {
                        continue;
                    }
                    ans = Math.min(ans, Math.abs(n - i * j * k));
                }
            }
        }
        System.out.println(ans);
    }
}