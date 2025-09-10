import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int res[] = new int [81];
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                for (int k = 1; k <= C; k++) {
                    res[i + j + k]++;
                }
            }
        }

        int max = 0;
        int answer = 0;
        for (int i = 3; i <= A + B + C; i++) {
            if (res[i] > max) {
                max = res[i];
                answer = i;
            }
        }
        System.out.println(answer);
    }
}