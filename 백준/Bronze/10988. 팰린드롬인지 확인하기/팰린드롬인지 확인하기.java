import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        StringBuilder str2 = sb.append(str).reverse();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                System.out.println("0");
                return;
            }
        }
        System.out.println("1");
    }
}