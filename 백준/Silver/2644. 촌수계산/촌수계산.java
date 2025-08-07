import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int A, B;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int count = -1;
  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        lists =new ArrayList[N+1];
           for (int i = 0; i < N+1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        
        dfs(A,0);
        System.out.println(count);
    }





    static void dfs(int i , int j){
        visited[i] = true;
      
        if (i == B) {
            count = j;
            return;
        }
       for (int n  : lists[i]) {
        if(!visited[n])
        dfs(n, j+1);
       }
    }


}