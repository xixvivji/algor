import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prev = new int[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 1) {
                break;
            }

            if (cur % 3 == 0 && dist[cur / 3] == -1) {
                queue.add(cur / 3);
                dist[cur / 3] = dist[cur] + 1;
                prev[cur / 3] = cur;
            }

            if (cur % 2 == 0 && dist[cur / 2] == -1) {
                queue.add(cur / 2);
                dist[cur / 2] = dist[cur] + 1;
                prev[cur / 2] = cur;
            }

            if (cur - 1 > 0 && dist[cur - 1] == -1) {
                queue.add(cur - 1);
                dist[cur - 1] = dist[cur] + 1;
                prev[cur - 1] = cur;
            }
        }

        System.out.println(dist[1]);

        List<Integer> path = new ArrayList<>(); //다시 찾아보기
        for (int i = 1; i != 0; i = prev[i]) {
            path.add(i);
            if (i == N) break;
        }
        Collections.reverse(path);
        for (int v : path) System.out.print(v + " ");
    }
}