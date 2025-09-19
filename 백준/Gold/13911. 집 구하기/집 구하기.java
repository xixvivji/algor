
import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<Node>[] list;
    static int M, x, S, y;
    static int[] mDist, sDist;
    static boolean[] isM, isS;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, value));
            list[to].add(new Node(from, value));
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        isM = new boolean[V + 1];
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> mList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(st.nextToken());
            isM[idx] = true;
            mList.add(idx);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        isS = new boolean[V + 1];
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> sList = new ArrayList<>();
        for (int i = 0; i < S; i++) {
            int idx = Integer.parseInt(st.nextToken());
            isS[idx] = true;
            sList.add(idx);
        }

    
        mDist = dijk(mList);
        sDist = dijk(sList);

        int answer = INF;
        for (int i = 1; i <= V; i++) {
            if (isM[i] || isS[i]) continue; 
            if (mDist[i] <= x && sDist[i] <= y) {
                answer = Math.min(answer, mDist[i] + sDist[i]);
            }
        }
        System.out.println(answer == INF ? -1 : answer);
    }

    
    
    static int[] dijk(ArrayList<Integer> starts) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int start : starts) {
            dist[start] = 0;
            pq.add(new Node(start, 0));
        }
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.value) continue;
            for (Node next : list[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.value) {
                    dist[next.to] = dist[cur.to] + next.value;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node> {
        int to, value;
        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}