import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        String[] srr = new String[len];
        for (int i = 0; i < len; i++) {
            srr[i] = str.substring(i);
        }
        Arrays.sort(srr);
        for (String s : srr) {
            System.out.println(s);
        }
    }
}