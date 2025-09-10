import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static ArrayList<Node>[] list;
    static int[][] result;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        N = Integer.parseInt(br.readLine());
        M  = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i = 1; i <=N;i++) {
        	list[i] = new ArrayList<>();
        }
        result = new int[N+1][N+1];
        
        
        for(int i= 0; i <M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	list[a].add(new Node(b,c));
        	
        	
        }
        
        for (int i = 1; i <= N; i++) {
            int[] dist = dijkstra(i);
            for (int j = 1; j <= N; j++) {
                result[i][j] = dist[j];
            }
        }

  
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print((result[i][j] == Integer.MAX_VALUE ? 0 : result[i][j]) + " ");
            }
            System.out.println();
        }
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.dist) continue;
            for (Node next : list[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.dist) {
                    dist[next.to] = dist[cur.to] + next.dist;
                    pq.add(new Node(next.to, dist[next.to]));
                } 
            }
        }
        return dist;
    }
    
    static class Node implements Comparable<Node>{
    	int to;
    	int dist;
    	Node(int to, int dist){
    		this.to = to;
    		this.dist = dist;
    	}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return dist - o.dist;
		}
    }
}