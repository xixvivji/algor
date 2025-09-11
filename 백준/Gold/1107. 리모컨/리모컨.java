
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res;
    static List<Integer> usable = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        
        for (int i = 0; i <= 9; i++) {
            if (!broken[i]) 
            	usable.add(i);
        }

        res = Math.abs(N - 100);

        for (int len = 1; len <= 6; len++) {
            int[] numArr = new int[len];
            dfs(0, len, numArr);
        }

        System.out.println(res);
    }

    static void dfs(int depth, int len, int[] arr) {
        if (depth == len) {
            int n = 0;
            for (int i = 0; i < len; i++) {
                n = n * 10 + arr[i];
            }
            
            int press = len + Math.abs(N - n);
            res = Math.min(res, press);
            return;
        }
        
        for (int btn : usable) {
            arr[depth] = btn;
            dfs(depth + 1, len, arr);
        }
    }
}