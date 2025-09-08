

import java.io.*;
import java.util.*;

public class Main {
    static int N,E;
    static ArrayList<node>[] list;
    static int[] dist;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
       
        visited = new boolean[N+1];
        for(int i= 0 ; i <= N; i++) {
        	list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new node(b,c));
			list[b].add(new node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int route1 = 0, route2 = 0;
        int INF = Integer.MAX_VALUE;

      
        int tmp1 = dijkstra(1, v1);
        int tmp2 = dijkstra(v1, v2);
        int tmp3 = dijkstra(v2, N);
        if (tmp1 == -1 || tmp2 == -1 || tmp3 == -1) route1 = INF;
        else route1 = tmp1 + tmp2 + tmp3;

        tmp1 = dijkstra(1, v2);
        tmp2 = dijkstra(v2, v1);
        tmp3 = dijkstra(v1, N);
        if (tmp1 == -1 || tmp2 == -1 || tmp3 == -1) route2 = INF;
        else route2 = tmp1 + tmp2 + tmp3;

        int ans = Math.min(route1, route2);
        System.out.println(ans >= INF ? -1 : ans);
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new node(start, 0));
        while (!pq.isEmpty()) {
            node cur = pq.poll();
            if (cur.to == end) return dist[end];
            if (cur.value > dist[cur.to]) continue;
            for (node next : list[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.value) {
                    dist[next.to] = dist[cur.to] + next.value;
                    pq.add(new node(next.to, dist[next.to]));
                }
            }
        }
        return -1; 
    }
    
    
    
    static class node implements Comparable<node>{

		public int compareTo(node o) {
			
			return  value - o.value;
		}
		int to;
		int value;
		node(int to, int value){
		this.to = to;
		this.value = value;
		}
    }
}