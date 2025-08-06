import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,V;
	static boolean[] visited;
	static ArrayList<Integer>[] lists;
	static StringBuilder sb;
	static StringBuilder sb2;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		// sb2 = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		lists =new ArrayList[N+1];
		q = new LinkedList<>(); 
		

		for(int i = 0; i<= N; i++){lists[i] = new ArrayList<>();}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			lists[a].add(b);
			lists[b].add(a);
			
		}
		for (ArrayList<Integer> list : lists) {
    	if (list != null) { 
       		Collections.sort(list);
    		}
		}
	
		dfs(V);
		System.out.println(sb.toString());

		visited = new boolean[N+1];
		sb = new StringBuilder();

		bfs(V);
		System.out.println(sb.toString());

	}


	

	static void dfs(int V){
		visited[V] = true;
		sb.append(V + " ");
		for (int i  : lists[V]) {
			if(!visited[i]){
			dfs(i);
			}
		}
	}


	static void bfs(int V){
		visited[V] =true;
		
		q.add(V);
		
		while (!q.isEmpty()) {
			int n = q.poll();
			sb.append(n + " ");
			for (int i : lists[n]) {
				if(!visited[i]){
					visited[i] =true;
					q.add(i);
				}
			}
		}
	}



}