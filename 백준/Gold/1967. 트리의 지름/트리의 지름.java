import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dist;
    static int maxDist = 0;
    static int farNode = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        dfs(1);

        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                farNode = i;
            }
        }

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        maxDist = 0;
        dfs(farNode);

        for (int i = 1; i <= N; i++) {
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