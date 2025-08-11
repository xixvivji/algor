import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean found = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited[i] = false;
            dfs(i, 0);
            if (found) break;
        }
        if (!found) System.out.println(0);
    }

    static void dfs(int i, int count) {
        if (count == 4) {
            System.out.println(1);
            found = true;
            return;
        }
        visited[i] = true;
        for (int j : list[i]) {
            if (!visited[j]) {
                dfs(j, count + 1);
                if (found) return;
            }
        }
        visited[i] = false;


    }
}