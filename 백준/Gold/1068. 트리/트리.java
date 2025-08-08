
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, remove, root, answer = 0;
    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) lists[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) root = i;
            else lists[parent].add(i);
        }
        remove = Integer.parseInt(br.readLine());
        if (remove == root) {
            System.out.println(0);
            return;
        }
        dfs(root);
        System.out.println(answer);
    }

    static void dfs(int node) {
        if (node == remove) return;
        int childCount = 0;
        for (int child : lists[node]) {
            if (child != remove) {
                dfs(child);
                childCount++;
            }
        }
        if (childCount == 0) answer++;
    }
}