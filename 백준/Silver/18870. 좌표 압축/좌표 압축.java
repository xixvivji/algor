
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = result[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(result);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int value : result) {
            if (!map.containsKey(value)) {
                map.put(value, rank);
                rank++;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int key : arr) {
            sb.append(map.get(key)).append(' ');
        }

        System.out.println(sb);
    }
}