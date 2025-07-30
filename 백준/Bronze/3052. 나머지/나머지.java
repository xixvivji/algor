import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int arr[] = new int[42];
        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n % 42]++;
            if (arr[n % 42] == 1) {
                count++;
            }
        }
        System.out.println(count);

    }
}