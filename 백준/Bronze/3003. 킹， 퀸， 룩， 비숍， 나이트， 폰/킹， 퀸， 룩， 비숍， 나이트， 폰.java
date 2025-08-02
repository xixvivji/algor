import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] set = new int[] {1, 1, 2, 2, 2, 8};
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(input[i]);
            System.out.print(set[i] - num + " ");
        }
    }
}