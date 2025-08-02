import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                arr[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                arr[c - 'A']++;
            }
        }
        int maxCount = 0;
        char ch = '?';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > maxCount) {
                maxCount = arr[i];
                ch = (char) (i + 'A');
            } else if (arr[i] == maxCount) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}