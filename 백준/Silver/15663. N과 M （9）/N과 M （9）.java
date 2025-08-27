import java.io.*;
import java.util.*;


public class Main {
	static boolean visited[];
	static int[] arr;
	static int[] ar;
	
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ar = new int[N];
		visited = new boolean[N];
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < ar.length; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ar);
		
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth)  {
		
		if(depth == M) {
			for(int n : arr) {
			sb.append(n + " ");
			}
			sb.append('\n');
			return;
		}
		   int be = -1;
	        for (int i = 0; i < N; i++) {
	            if (!visited[i] && ar[i] != be) {
	                visited[i] = true;
	                arr[depth] = ar[i];
	                be = ar[i];
	                dfs(depth + 1);
	                visited[i] = false;
	            }
	        }
	    }
	}