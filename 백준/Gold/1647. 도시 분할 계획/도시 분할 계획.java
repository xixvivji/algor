
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
        }
        
        
        System.out.println(prim());
      
    }

    static int prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N+1];
        int total = 0;
        int maxEdge = 0;
        pq.add(new Node(1, 0));
        int count = 0;

        while (!pq.isEmpty() && count < N) {
            Node cur = pq.poll();
            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            total += cur.value;
            if (cur.value > maxEdge) maxEdge = cur.value;
            count++;

            for (Node next : list[cur.to]) {
                if (!visited[next.to]) pq.add(next);
            }
        }

        return total - maxEdge;
    }
    
    
    
    static class Node implements Comparable<Node>{

		public int compareTo(Node o) {
			
			return  value - o.value;
		}
		int to;
		int value;
		Node(int to, int value){
		this.to = to;
		this.value = value;
		}
    }
}