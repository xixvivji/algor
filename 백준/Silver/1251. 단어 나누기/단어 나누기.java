import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String s = null;

        int n = line.length();
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                String a = new StringBuilder(line.substring(0, i)).reverse().toString();
                String b = new StringBuilder(line.substring(i, j)).reverse().toString();
                String c = new StringBuilder(line.substring(j)).reverse().toString();
                String cand = a + b + c;
                if (s == null || cand.compareTo(s) < 0) {
                    s = cand;
                }
            }
        }

        System.out.println(s);
    }
}