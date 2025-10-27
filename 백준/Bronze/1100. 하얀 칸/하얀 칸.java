
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        for (int r = 0; r < 8; r++) {
            String line = br.readLine();
            for (int c = 0; c < 8; c++) {
                if (((r + c) & 1) == 0 && line.charAt(c) == 'F') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}