
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int z = 0; z < T; z++) {
            int N = Integer.parseInt(br.readLine()); 
            int[][] score = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken()); 
            }

            Arrays.sort(score, (a, b) -> Integer.compare(a[0], b[0]));

            int min_interview = score[0][1];
            int count = 1; 
            for (int i = 1; i < N; i++) {
                if (score[i][1] < min_interview) {
                    count++;
                    min_interview = score[i][1];
                }
            }
            System.out.println(count);
        }
    }
}