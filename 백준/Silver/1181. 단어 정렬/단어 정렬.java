import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        String[] srr = new String[N];
        for (int i = 0; i < N; i++) {
            srr[i] = br.readLine();
        }
        Arrays.sort(srr, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        String prev = "";
        for (int i = 0; i < N; i++) {
            if (!srr[i].equals(prev)) {
                System.out.println(srr[i]);
                prev = srr[i];
            }
        }
    }
}