import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean tag = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '<') {

                sb.append(word.reverse());
                word.setLength(0);
                tag = true;
                sb.append(c);
            } else if (c == '>') {
                tag = false;
                sb.append(c);
            } else if (tag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    sb.append(word.reverse());
                    sb.append(' ');
                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }
        }

        sb.append(word.reverse());
        System.out.println(sb);
    }
}