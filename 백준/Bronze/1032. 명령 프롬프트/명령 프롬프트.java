import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        String str = br.readLine();
        char[] chars = str.toCharArray();

        for (int i = 1; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != s.charAt(j)) {
                    chars[j] = '?';
                }
            }
        }

        System.out.println(new String(chars));
    }
}