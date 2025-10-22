import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] parent = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[b] = a; 
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int lastA = Integer.parseInt(st.nextToken());
            int	lastB = Integer.parseInt(st.nextToken());

            
            boolean[] visited = new boolean[N + 1];
            int cur = lastA;
            
            while (cur != 0) {
                visited[cur] = true;
                cur = parent[cur];
            }

            cur = lastB;
            
            while (!visited[cur]) {
                cur = parent[cur];
            }

            System.out.println(cur);
        }

     
    }
}