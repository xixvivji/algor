import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] arr = new int[P];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        int rank = 1;

        for (int i = 0; i < N; i++) {
            if (arr[i] > score) {
                rank++;
            } else if (arr[i] == score) {
                rank = rank;
            } else {
                break;
            }
        }

        if (N == P && arr[N - 1] >= score) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}