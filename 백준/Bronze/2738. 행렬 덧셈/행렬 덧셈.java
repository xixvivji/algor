import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr2[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr1[i][j] + arr2[i][j] + " ");
            }
            System.out.println();
        }

    }

}