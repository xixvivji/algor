import java.io.*;
import java.util.*;
public class Main {
    static int N, K;
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        Arrays.fill(time, Integer.MAX_VALUE); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int n) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(n);
        time[n] = 0;

        while (!dq.isEmpty()) {
            int current = dq.poll();

            if (current == K) {
                System.out.println(time[current]);
                return;
            }

            if (current * 2 < time.length && time[current * 2] > time[current]) {
                dq.addFirst(current * 2);
                time[current * 2] = time[current];
            }
            if (current + 1 < time.length && time[current + 1] > time[current] + 1) {
                dq.addLast(current + 1);
                time[current + 1] = time[current] + 1;
            }
            if (current - 1 >= 0 && time[current - 1] > time[current] + 1) {
                dq.addLast(current - 1);
                time[current - 1] = time[current] + 1;
            }
        }
    }
}