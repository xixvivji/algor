

import java.io.*;
import java.util.*;

public class Main {
    static int N,M,X;
    static ArrayList<node>[] list;
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i = 0; i<= N; i++) {
        	list[i] = new ArrayList<>();
        	
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int value = Integer.parseInt(st.nextToken());
        	list[from].add(new node(to,value));
        	
        }
        int res[] = new int [N+1];
       for(int i = 1; i <= N; i++) {
    	   res[i] += bfs(i,X);
    	   res[i] += bfs(X,i);
       }
        
      Arrays.sort(res);
        
        System.out.println(res[N]);
    
    }// main
    
   static int bfs(int start, int end) {
	  
	   int dist[] = new int [N+1];
	  Arrays.fill(dist,Integer.MAX_VALUE);
	   PriorityQueue<node> pq = new PriorityQueue<>();
	   dist[start] = 0;
	   pq.add(new node(start, 0));
	   while(!pq.isEmpty()) {
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
    	int to;
    	int value;
    	node(int to, int value){
    		this.to = to;
    		this.value = value;
    		
    	}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return value - o.value;
		}
    }
  
    
    
}