import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        long halfSum = 0;
        
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            sum += h;
            halfSum += h / 2;
        }

        if (sum % 3 == 0) {
            long t = sum / 3;
            if (halfSum >= t) System.out.println("YES");
            else System.out.println("NO");
        } else {
            System.out.println("NO");
        }
    }
}