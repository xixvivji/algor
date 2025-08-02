import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] str = input.split(" ");
        StringBuilder a = new StringBuilder(str[0]).reverse();
        StringBuilder b = new StringBuilder(str[1]).reverse();

        System.out.println(Integer.parseInt(a.toString()) > Integer.parseInt(b.toString()) ? a : b);
    }
}