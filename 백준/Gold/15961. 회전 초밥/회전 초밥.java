import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;


        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        max = map.containsKey(c) ? map.size() : map.size() + 1;

  
        for (int i = 1; i < N; i++) {
            
            int leftIdx = arr[(i - 1) % N];
            map.put(leftIdx, map.get(leftIdx) - 1);
            if (map.get(leftIdx) == 0) map.remove(leftIdx);

           
            int rightIdx = arr[(i + k - 1) % N];
            map.put(rightIdx, map.getOrDefault(rightIdx, 0) + 1);

            int curr = map.containsKey(c) ? map.size() : map.size() + 1;
            max = Math.max(max, curr);
        }

        System.out.println(max);
    }
}