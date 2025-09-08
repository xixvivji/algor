
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<node>[] list;
    static int[] dist;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
       
        visited = new boolean[N+1];
        for(int i= 0 ; i <= N; i++) {
        	list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new node(b,c));
			list[b].add(new node(a,c));
        }
        
        
        System.out.println(prim());
      
    }

    static int prim() {
      
        PriorityQueue<node> pq = new PriorityQueue<>();
        int dist = 0;
        
        pq.add(new node(1, 0));
        while (!pq.isEmpty()) {
            node cur = pq.poll();
           if(visited[cur.to])
        	   continue;
          visited[cur.to] = true;
          dist += cur.value;
          for(node next : list[cur.to]) {
        	  if(!visited[next.to])
        		  pq.add(next);
          }
        }
        return dist; 
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