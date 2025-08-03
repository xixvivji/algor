import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[9][9];
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(tokens[j]);
               max = Math.max(arr[i][j], max);

            }

        }
        System.out.println(max);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == max) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }

    }
}