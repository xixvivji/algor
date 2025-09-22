import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String line = "UCPC";
        int idx = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == line.charAt(idx)) {
                idx++;
                if (idx == 4) break;
            }
        }
        if (idx == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}