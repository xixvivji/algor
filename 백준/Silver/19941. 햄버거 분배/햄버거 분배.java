import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] table = br.readLine().toCharArray();
        boolean[] eaten = new boolean[N];

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (table[i] == 'P') {
                for (int j = i - K; j <= i + K; j++) {
                    if (j >= 0 && j < N) {
                        if (table[j] == 'H' && !eaten[j]) {
                            eaten[j] = true; 
                            count++;
                            break; 
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}