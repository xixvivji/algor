import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int sum = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 1; i <= N; i++) {
            int currentSum = bfs(i);
            if (currentSum < sum) {
                sum = currentSum;
                result = i;
            }
        }
        System.out.println(result);
    }

    static int bfs(int i) {
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int n : list[current]) {
                if (!visited[n]) {
                    visited[n] = true;
                    distance[n] = distance[current] + 1;
                    q.add(n);
                }
            }
        }

        int baconSum = 0;
        for (int n = 1; n <= N; n++) {
            baconSum += distance[n];
        }
        return baconSum;
    }
}