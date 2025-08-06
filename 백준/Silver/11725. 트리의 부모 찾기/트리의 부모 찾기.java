
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] lists;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        lists = new ArrayList[N + 1];
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int i : lists[start]) {
            if (!visited[i]) {

                dfs(i);
                parents[i] = start;
            }
        }

    }


}
