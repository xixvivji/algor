import java.io.*;
import java.util.*;


public class Main {
    
    static int N, K, S;
    static boolean[][] res; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        

        res = new boolean[N + 1][N + 1];
        

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            res[a][b] = true; 
        }
        

        for (int k = 1; k <= N; k++) { 
            for (int i = 1; i <= N; i++) { 
                for (int j = 1; j <= N; j++) { 

                    if (res[i][k] && res[k][j]) {
                    	res[i][j] = true;
                    }
                }
            }
        }
        

        S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (res[a][b]) { 

                sb.append("-1\n");
            } else if (res[b][a]) { 

                sb.append("1\n");
            } else { 

                sb.append("0\n");
            }
        }
        System.out.print(sb);
    }
}