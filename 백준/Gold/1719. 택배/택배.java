
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] list;
    static final int INF = Integer.MAX_VALUE; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }

     
        int[][] result = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = dijk(i, n); 
        }

  
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append("- ");
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static int[] dijk(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];       
        int[] res = new int[n + 1]; 

        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.weight > dist[cur.to]) { 
                continue;
            }
            for (Node next : list[cur.to]) { 
                
               
                if (dist[next.to] > dist[cur.to] + next.weight) { 
                    
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));

                 
                    if (cur.to == start) {
                       
                    	res[next.to] = next.to;
                    } else {                     
                    	res[next.to] = res[cur.to];
                    }
                }
            }
        }
        
        return res;
    }
    
    
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
         
            return this.weight - o.weight;
        }
    }
    
    
}