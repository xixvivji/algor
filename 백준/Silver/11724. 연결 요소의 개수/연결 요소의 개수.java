import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int node;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException,NoSuchElementException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        visited =new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            
        }

        for(int i = 0; i < node; i++ ){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);

        }
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                count++;
            dfs(i);
            }
        }
        System.out.println(count);
    }

 private static void dfs(int n) {
        
        visited[n] = true;
        for (int i : graph[n]) {
            
            if (!visited[i]) {
                
                dfs(i);
            }

        }
    }
}