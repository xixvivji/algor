import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, D;
    static ArrayList<node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (to <= D && (to - from) > len) {
                list[from].add(new node(to, len));
            }
        }
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int j = 0; j < D; j++) {
            dist[j + 1] = Math.min(dist[j + 1], dist[j] + 1);
            for (node next : list[j]) {
                dist[next.to] = Math.min(dist[next.to], dist[j] + next.len);
            }
        }
        System.out.println(dist[D]);
    }

    static class node {
        int to;
        int len;

        node(int to, int len) {
            this.to = to;
            this.len = len;
        }
    }
}