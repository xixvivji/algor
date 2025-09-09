import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        char[] ch = String.valueOf(N).toCharArray();
        Character[] chArr = new Character[ch.length];
        for (int i = 0; i < ch.length; i++) {
            chArr[i] = ch[i];
        }
        Arrays.sort(chArr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Character c : chArr) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}