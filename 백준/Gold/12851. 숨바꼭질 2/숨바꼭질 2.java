

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N, K);
    }

    static void bfs(int start, int end) {
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        int minTime = Integer.MAX_VALUE;
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (minTime < visited[now]) {
                break;
            }

            if (now == end) {
                minTime = visited[now];
                count++;
            }

            for (int next : Arrays.asList(now - 1, now + 1, now * 2)) {
                if (next < 0 || next > 100000) {
                    continue;
                }
                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    queue.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
        System.out.println((minTime - 1) + "\n" + count);
    }
}