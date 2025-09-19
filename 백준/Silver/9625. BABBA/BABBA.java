import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        int[] dpA = new int[K + 1];
        int[] dpB = new int[K + 1];

        dpA[0] = 1;
        dpB[0] = 0;

        dpA[1] = 0;
        dpB[1] = 1;

        for (int i = 2; i <= K; i++) {
            dpA[i] = dpA[i - 1] + dpA[i - 2];
            dpB[i] = dpB[i - 1] + dpB[i - 2];
        }

        System.out.println(dpA[K] + " " + dpB[K]);
    }
}
    