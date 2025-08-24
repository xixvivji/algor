
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    lists[i].add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i);

            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    result[i][j] = 1;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int start) {
        for (int nextNode : lists[start]) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode);
            }
        }
    }
}