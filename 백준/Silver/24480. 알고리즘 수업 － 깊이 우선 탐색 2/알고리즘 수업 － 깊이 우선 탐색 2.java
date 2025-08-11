import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

    for (int i = 1; i <= N; i++) {
    Collections.sort(list[i], Collections.reverseOrder());
}

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        order[node] = cnt++;
        for (int next : list[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}