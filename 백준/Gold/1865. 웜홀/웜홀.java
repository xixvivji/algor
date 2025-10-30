
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Edge>[] list;
    static int N, M, W;
    static int [] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); 
        
        for(int tc = 1; tc <= T; tc ++) {
            st= new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
                    
            list = new ArrayList[N+1];
            for(int i = 0 ; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            
         
            for(int i = 0 ; i < M; i++) {
                st =new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                list[from].add(new Edge(to, value));
                list[to].add(new Edge(from, value));
            }
          
            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                list[from].add(new Edge(to, -value));
            }
            
         
            if (Bellmanford()) { 
                sb.append("NO\n");
            } else { 
                sb.append("YES\n");
            }
            
        }//tc
        
        System.out.print(sb); 
        
    } //main

    
    static boolean Bellmanford() {
        dist = new int[N + 1];
       
        for (int i = 1; i < N; i++) {
            for (int u = 1; u <= N; u++) {
                for (Edge edge : list[u]) {
                  
                    if (dist[edge.to] > dist[u] + edge.value) {
                        dist[edge.to] = dist[u] + edge.value;
                    }
                }
            }
        }

      
        for (int u = 1; u <= N; u++) {
            for (Edge edge : list[u]) {
               
                if (dist[edge.to] > dist[u] + edge.value) {
                    return false; 
                }
            }
        }
        return true; 
    }

    static class Edge {
        int to;
        int value;
         Edge(int to, int value) {
            this.to = to;
            this.value = value;
        }
     
    }
    
}