
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = new String[5];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
            if (lines[i].length() > maxLen) maxLen = lines[i].length();
        }

        char[][] ch = new char[5][maxLen];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < maxLen; j++) {
                if (j < lines[i].length()) {
                    ch[i][j] = lines[i].charAt(j);
                } else {
                    ch[i][j] = ' ';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < maxLen; j++) {
            for (int i = 0; i < 5; i++) {
                if (ch[i][j] != ' ') {
                    sb.append(ch[i][j]);
                }
            }
        }
        System.out.println(sb.toString());
    }
}