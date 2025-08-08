import java.util.Scanner;import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        Arrays.sort(points, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0]; 
            return a[1] - b[1];
        });

        for (int i = 0; i < N; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}
