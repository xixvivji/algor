
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] list;
    static boolean [] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i = 0; i <=N; i++) {
        	list[i] = new ArrayList<>();
        }
       
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) list[i].add(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean possible = true;
        for (int i = 0; i < M - 1; i++) {
            if (bfs(arr[i], arr[i + 1]) == -1) {
                possible = false;
                break;
            }
        }
        System.out.println(possible ? "YES" : "NO");
    }
    
    static int bfs(int start, int end) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) return 0; 
            for (int next : list[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return -1; 
    }
    
    
}