
import java.io.*;
import java.util.*;

public class Main {
    static int N, start, end;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int totalSum = 0, maxEdge = 0;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, value));
            list[to].add(new Node(from, value));
        }

        visited = new boolean[N+1];
        dfs(start, 0, 0);
        System.out.println(totalSum - maxEdge);
    }

    static void dfs(int cur, int sum, int curMax) {
        if (cur == end) {
            totalSum = sum;
            maxEdge = curMax;
            found = true;
            return;
        }
        visited[cur] = true;
        for (Node n : list[cur]) {
            if (!visited[n.to] && !found) {
                dfs(n.to, sum + n.value, Math.max(curMax, n.value));
            }
        }
    }

    static class Node {
        int to, value;
        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}