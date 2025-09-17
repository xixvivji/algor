import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Node>[] list;
    
    static int[] dist;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
       
        
        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < N-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list[a].add(new Node(b,c));
        	list[b].add(new Node(a,c));
        	
        }
        
        for(int i = 0 ; i < M ; i++) {
        
        st= new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        
        
        bfs(from,to);
        System.out.println(dist[to]);
        }
        
                     
    }

    
    
    static void bfs(int start, int end) {
    	dist = new int [N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
        	
        	Node cur = pq.poll();
        	
        	if(cur.to == end)break;
        	if(dist[cur.to] < cur.value)continue;
        	
        	for(Node next : list[cur.to]) {
        		if(dist[next.to] > dist[cur.to] + next.value) {
        			dist[next.to] = dist[cur.to] + next.value;
        			pq.add(new Node(next.to, dist[next.to]));
        		}
        	}
        	
        	
        }
        
        

        
    }

    static class Node implements Comparable<Node>{
    	public int compareTo(Node o) {
    		return value - o.value;
    		
    	}
    	
        int to, value;
        Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}