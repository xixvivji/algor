
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }

            boolean[] visited = new boolean[n + 1];
            int treeCount = 0;

            for (int i = 1; i <= n; i++) {
                if (visited[i]) continue;
                
                Queue<Integer> q = new ArrayDeque<>();
                visited[i] = true;
                q.add(i);
                int nodes = 0;
                int sum = 0;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    nodes++;
                    sum += adj[cur].size();
                    for (int next : adj[cur]) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }
                
                int edges = sum / 2;
                if (edges == nodes - 1) treeCount++;
            }

            if (treeCount == 0) {
                sb.append("Case ").append(cnt++).append(": No trees.").append('\n');
            } else if (treeCount == 1) {
                sb.append("Case ").append(cnt++).append(": There is one tree.").append('\n');
            } else {
                sb.append("Case ").append(cnt++).append(": A forest of ").append(treeCount).append(" trees.").append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}