import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001]; 

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            count[arr[i] + 4000]++;
        }

        Arrays.sort(arr);

        System.out.println(Math.round((double)sum/N));
        // 중앙값
        System.out.println(arr[N/2]);
        
        // 최빈값
        int maxCount = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        ArrayList<Integer> modes = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxCount) {
                modes.add(i - 4000);
            }
        }

        if (modes.size() > 1) {
            System.out.println(modes.get(1));
        } else {
            System.out.println(modes.get(0));
        }

        System.out.println(arr[N-1] - arr[0]);
    }
}