
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        int[][] count = new int[4][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                int s = Integer.parseInt(st.nextToken());
                arr[j] += s;
                count[j][s]++;
            }
        }

        int res = 1;
        boolean tie = false;
        for (int i = 2; i <= 3; i++) {
            if (arr[i] > arr[res]) {
                res = i;
                tie = false;
            } else if (arr[i] == arr[res]) {
                if (count[i][3] > count[res][3]) {
                    res = i;
                    tie = false;
                } else if (count[i][3] == count[res][3]) {
                    if (count[i][2] > count[res][2]) {
                        res = i;
                        tie = false;
                    } else if (count[i][2] == count[res][2]) {
                        tie = true;
                    }
                }
            }
        }

        if (tie) {
            System.out.println("0 " + arr[res]);
        } else {
            System.out.println(res + " " + arr[res]);
        }
    }
}