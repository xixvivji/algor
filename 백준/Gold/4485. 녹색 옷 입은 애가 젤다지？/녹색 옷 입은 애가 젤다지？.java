
import java.io.*;
import java.util.*;




public class Main {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
 	static int[][]dp;
	static int[][]arr;
	static int n;
	static boolean visited[][];
	static int num =1;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	while(true) {
    		n = Integer.parseInt(br.readLine());
    		if(n == 0) break;
    		 visited = new boolean[n][n];
    		 arr =new int[n][n];
    		 dp = new int[n][n];
    		 dp[0][0] = arr[0][0];
    		 
    		 for(int i = 0; i < n ;i++) {
    			 st = new StringTokenizer(br.readLine());
    			 for(int j = 0; j < n ; j ++) {
    				 arr[i][j] = Integer.parseInt(st.nextToken());
    			 }
    		 }
    		 
    		 System.out.println("Problem"+ " " +  num++  +":" +" " + bfs(0,0));
    		 
    	}
    	
    	
    }
    
    static int bfs(int x , int y) {
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, 99999);
        PriorityQueue<node> pq = new PriorityQueue<>();
        dp[x][y] = arr[0][0];
        pq.add(new node(0, 0, dp[0][0]));

        while (!pq.isEmpty()) {
            node cur = pq.poll();
            if (cur.cost > dp[cur.x][cur.y]) 
            	continue; 
            if (cur.x == n - 1 && cur.y == n - 1) 
            	return cur.cost; 

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) 
                	continue;

                int nw = cur.cost + arr[nx][ny];
                if (nw < dp[nx][ny]) {
                    dp[nx][ny] = nw;
                    pq.add(new node(nx, ny, nw));
                }
            }
        }
        return dp[n - 1][n - 1];
    }

    
    static class node implements Comparable<node>{
    	int x;
    	int y; 
    	int cost;
    	 node(int x,int y,int cost) {
    		this.x = x;
    		this.y = y;
    		this.cost = cost;
    	}
    	  @Override
          public int compareTo(node o) {
              return this.cost - o.cost;
          }
    }
}