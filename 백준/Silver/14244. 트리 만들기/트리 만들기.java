import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());


        System.out.println("0 1");

        for (int i = 2; i <= L; i++) {
            System.out.println("1 " + i);
        }

        for (int i = L + 1; i < N; i++) {
            System.out.println((i - 1) + " " + i);
        }
    }
}