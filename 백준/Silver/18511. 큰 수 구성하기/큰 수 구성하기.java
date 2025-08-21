import java.io.*;
import java.util.*;
public class Main {
    static int N, K, answer = 0;
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) 
        	S[i] = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int num) {
        if (num > N) return;
        if (num > answer) 
        	answer = num;
        for (int i = 0; i < K; i++) {
            dfs(num * 10 + S[i]);
        }
    }
}