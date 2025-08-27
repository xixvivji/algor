import java.io.*;
import java.util.*;


public class Main {

	static int[] arr;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		dfs(0);
				System.out.println(sb);

	}

	public static void dfs(int depth) throws IOException {
		if(depth == M) {
			for(int n : arr) {
			sb.append(n + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
	
				arr[depth] = i+1;
				dfs( depth + 1);
			
		}

	}
}