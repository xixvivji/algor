
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int count, answer, N;
    static boolean found;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            count = 0;
            answer = 0;
            found = false;
            for (int len = 1; len <= 10 && !found; len++) {
                dfs(0, len, 0, new boolean[10]);
            }
            System.out.println(answer);
        }
    }

    static void dfs(int depth, int maxLen, int num, boolean[] used) {
        if (found) {
            return;
        }
        if (depth == maxLen) {
            count++;
            if (count == N) {
                answer = num;
                found = true;
            }
            return;
        }
        for (int d = (depth == 0 ? 1 : 0); d <= 9; d++) {
            if (!used[d]) {
                used[d] = true;
                dfs(depth + 1, maxLen, num * 10 + d, used);
                used[d] = false;
            }
        }
    }
}