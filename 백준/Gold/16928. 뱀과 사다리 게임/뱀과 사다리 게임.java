import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] move = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 100; i++) {
            move[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            move[from] = to;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            move[from] = to;
        }

        // BFS로 최소 이동 횟수 구하기
        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int dice = 1; dice <= 6; dice++) {
                int next = now + dice;
                if (next > 100) continue;
                next = move[next];
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }

        System.out.println(dist[100]);
    }
}