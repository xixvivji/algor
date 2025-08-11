import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, V, E;
    static ArrayList<Integer>[] list;
    static int[] color;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());

        for (int z = 0; z < K; z++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V + 1];
            color = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    dfs(i, 1);
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static void dfs(int node, int c) {
        color[node] = c;
        for (int next : list[node]) {
            if (color[next] == 0) {
                dfs(next, 3 - c); 
            } else if (color[next] == color[node]) {
                isBipartite = false;
            }
        }
    }
}