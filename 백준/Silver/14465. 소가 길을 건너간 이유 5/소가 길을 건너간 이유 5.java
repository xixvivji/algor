import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            int d = Integer.parseInt(br.readLine());
            arr[d] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= K; i++) {
            if (arr[i]) cnt++;
        }
        int min = cnt;

        for (int i = K + 1; i <= N; i++) {
            if (arr[i - K]) cnt--;
            if (arr[i]) cnt++;
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }
}