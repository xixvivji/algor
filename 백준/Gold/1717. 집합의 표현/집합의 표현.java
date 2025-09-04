
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		  int n = Integer.parseInt(st.nextToken());
          int m = Integer.parseInt(st.nextToken());
          
          parent = new int[n + 1];
          for (int i = 1; i <= n; i++) parent[i] = i;

          for (int i = 0; i < m; i++) {
              st = new StringTokenizer(br.readLine());
              int op = Integer.parseInt(st.nextToken());
              int a = Integer.parseInt(st.nextToken());
              int b = Integer.parseInt(st.nextToken());
              if (op == 0) {
                  union(a, b);
              } else {
                  sb.append(find(a) == find(b) ? "YES" : "NO");
                  sb.append("\n");
              }
          
          }
     

      System.out.print(sb);
}

  static int find(int x) {
      if (parent[x] == x) return x;
      return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
      int pa = find(a);
      int pb = find(b);
      if (pa != pb) parent[pa] = pb;
  }
}