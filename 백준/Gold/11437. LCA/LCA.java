
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
        	list[i] = new ArrayList<>();
        }

      
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

     
        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList();
        int root = 1;
        q.add(root);
        visited[root] = true;
        parent[root] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : list[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }

        int M = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

           
            boolean[] visited2 = new boolean[N + 1];
            int cur = x;
            while (cur != 0) {
            	visited2[cur] = true;
                cur = parent[cur];
            }

            cur = y;
            while (!visited2[cur]) {
                cur = parent[cur];
            }

            sb.append(cur).append('\n');
        }

        System.out.print(sb.toString());
    }
}