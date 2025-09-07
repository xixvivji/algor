import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] brr;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            brr = new int[n + 1];
            list = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                brr[i] = i;
            }
            for (int i = 1; i <= n; i++) {
                list[arr[i]].add(brr[i]);
            }
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);
        } // tc
    }

    static void dfs(int start) {
        visited[start] = true;
        for (int n : list[start]) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
    }
}