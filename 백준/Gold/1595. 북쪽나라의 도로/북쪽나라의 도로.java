
import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 1;
    static int maxNodeNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        list = new ArrayList[10001];
        for (int i = 0; i < 10001; i++) {
            list[i] = new ArrayList<>();
        }

        boolean hasInput = false;
        while ((line = br.readLine()) != null && !line.equals("")) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
            maxNodeNum = Math.max(maxNodeNum, Math.max(a, b));
            hasInput = true;
        }

        if (!hasInput) {
            System.out.println(0);
            return;
        }

        int start = 1;
        for (int i = 1; i <= maxNodeNum; i++) {
            if (!list[i].isEmpty()) {
                start = i;
                break;
            }
        }

        visited = new boolean[10001];
        maxDist = 0;
        dfs(start, 0);

        visited = new boolean[10001];
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int now, int dist) {
        visited[now] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farNode = now;
        }
        for (Node next : list[now]) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.value);
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