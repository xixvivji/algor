
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            boolean[] used = new boolean[26];
            boolean isGroupWord = true;
            char prev = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c != prev) {
                    if (used[c - 'a']) {
                        isGroupWord = false;
                        break;
                    }
                    used[c - 'a'] = true;
                }
                prev = c;
            }
            if (isGroupWord) {
                count++;
            }
        }
        System.out.println(count);
    }
}