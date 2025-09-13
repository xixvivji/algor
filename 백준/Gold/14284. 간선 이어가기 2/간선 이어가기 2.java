
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static ArrayList<Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M ; i++) {
        	st= new StringTokenizer(br.readLine());
        	int to = Integer.parseInt(st.nextToken());
        	int from = Integer.parseInt(st.nextToken());
        	int value = Integer.parseInt(st.nextToken());
        	
        	list[to].add(new Node(from,value));
        	list[from].add(new Node(to,value));
        	
        }
        
        st =new StringTokenizer(br.readLine());
        int start= Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        
        bfs(start);
        
        System.out.println(dist[end]);
        
     
    
        
        
    }
    
    
    static void bfs(int start) {
    	dist = new int[N+1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	dist[start] = 0;
    	pq.add(new Node(start,0));
    
    	
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		if(dist[cur.to] < cur.value) continue;
    		
    		for(Node next : list[cur.to]) {
    			
    			if(dist[next.to] > dist[cur.to] + next.value) {
    				dist[next.to] = dist[cur.to] + next.value; 
        			pq.add(new Node(next.to, dist[next.to] ));

    			}	
    
    			
    			
    		}
    		
    	}
   }
    
    
    
    
    static class Node implements Comparable<Node>{
    	int to, value;
    	Node(int to, int value){
    		this.to =to;
    		this.value = value;
    	}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return value - o.value;
		}
    }
    
}