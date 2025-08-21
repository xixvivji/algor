import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                lis.add(num);
            } else {
                int left = 0, right = lis.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (lis.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                lis.set(left, num);
            }
        }
        
        System.out.println(lis.size());
    }
}
