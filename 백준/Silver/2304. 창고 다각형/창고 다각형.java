
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] height = new int[1001];
        int left = 1001, right = 0, maxHeight = 0, maxIdx = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            height[x] = h;
            left = Math.min(left, x);
            right = Math.max(right, x);
            if(h > maxHeight) {
                maxHeight = h;
                maxIdx = x;
            }
        }

        int sum = 0;
       
        int temp = 0;
        for(int i = left; i <= maxIdx; i++) {
            temp = Math.max(temp, height[i]);
            sum += temp;
        }
     
        temp = 0;
        for(int i = right; i >= maxIdx; i--) {
            temp = Math.max(temp, height[i]);
            sum += temp;
        }
        
        sum -= height[maxIdx];

        System.out.println(sum);
    }
}