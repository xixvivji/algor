
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }

        int odd = 0;
        int oddIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                oddIdx = i;
            }
        }
        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                left.append((char) (i + 'A'));
            }
        }
        StringBuilder right = new StringBuilder(left).reverse();
        if (odd == 1) {
            left.append((char) (oddIdx + 'A'));
        }
        left.append(right);
        System.out.println(left);
    }
}