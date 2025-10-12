import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; i + k < n && j + k < m; k++) {
                    if (arr[i][j] == arr[i][j + k] &&
                            arr[i][j] == arr[i + k][j] &&
                            arr[i][j] == arr[i + k][j + k]) {
                        max = Math.max(max, (k + 1) * (k + 1));
                    }
                }
            }
        }
        System.out.println(max);
    }
}