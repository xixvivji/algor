import java.io.*;
import java.util.*;


public class Main {

	static int[] arr;
	static boolean[] visit;
	static int N,M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N];
		dfs(N, M, 0);
		
	}

	public static void dfs(int N, int M, int depth) {
		if(depth == M) {
			for(int n : arr) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(N, M, depth + 1);
				
				visit[i] = false;
			}
		}

	}
}