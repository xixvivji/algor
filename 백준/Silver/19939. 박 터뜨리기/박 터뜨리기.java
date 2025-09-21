import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = K * (K + 1) / 2;
        if (N < min) {
            System.out.println(-1);
            return;
        }

        int remain = N - min;
        int minBasket = 1 + (remain / K);
        int maxBasket = K + (remain / K);
        if (remain % K != 0) {
            maxBasket += 1;
        }

        System.out.println(maxBasket - minBasket);
    }
}