import java.io.*;
import java.util.*;


public class Main {
	static boolean visited[];
	static int[] arr;

	
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	
		visited = new boolean[N];
		arr = new int[N];
	
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth)  {
		
		if(depth == N) {
			for(int n : arr) {
			sb.append(n + " ");
			}
			sb.append('\n');
			return;
		}
		for(int i = 0; i< N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i +1;
				dfs(depth+1);
				visited[i] =false;
			}
		}
		  
	      
	    }
	}