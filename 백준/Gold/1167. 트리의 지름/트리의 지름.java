import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;
    static int maxDist = 0;
    static int farNode = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }
                int value = Integer.parseInt(st.nextToken());
                list[node].add(new Node(to, value));
            }
        }

        visited = new boolean[V + 1];
        dist = new int[V + 1];
        dfs(1);

        for (int i = 1; i <= V; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                farNode = i;
            }
        }

        visited = new boolean[V + 1];
        dist = new int[V + 1];
        maxDist = 0;
        dfs(farNode);

        for (int i = 1; i <= V; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }

        System.out.println(maxDist);
    }

    static void dfs(int now) {
        visited[now] = true;

        for (Node next : list[now]) {
            if (!visited[next.to]) {
                dist[next.to] = dist[now] + next.value;
                dfs(next.to);
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