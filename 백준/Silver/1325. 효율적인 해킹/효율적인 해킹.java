import java.io.*;
import java.util.*;


public class Main {

	static ArrayList<Integer>[] lists;
	static boolean[] visit;
	static int N,M;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lists = new ArrayList[N+1];
		visit = new boolean[N+1];
	
		for (int i = 0; i <= N; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		for(int i=0; i <M ; i++){
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists[b].add(a);
		}
		
 		int max = 0;
        int[] answer = new int[N + 1];
		for(int i = 1; i<=N; i++){
			visit = new boolean[N + 1];
			count =0;
			dfs(i);
			answer[i] = count;
			max = Math.max(max, count);
			
		}
		for (int i = 1; i <= N; i++) {
			if (answer[i]== max) {
				System.out.print(i + " ");
				
			}
		}
		
	}



	public static void dfs(int i) {
		visit[i] = true;
		
		for (int n : lists[i]) {
			if (!visit[n]) {
				count++;
				dfs(n);
				
			}	
		}
		
	}
}