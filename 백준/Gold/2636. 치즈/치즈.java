import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int hour;
	static int N,M;
	static int [][]map;
	static boolean [][] visited;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0 ;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
	     int hour = 0;
	     int lastCheese = 0;
	     
	        while(true) {
	            int cheese = countCheese();
	            if(cheese == 0) break;
	            lastCheese = cheese;
	            visited = new boolean[N][M];
	           
	            dfs(0, 0);
	          
	            for(int i = 0; i < N; i++) {
	                for(int j = 0; j < M; j++) {
	                    if(map[i][j] == 2) 
	                    	map[i][j] = 0;
	                }
	            }
	            hour++;
	        }
	        
	        System.out.println(hour);
	        System.out.println(lastCheese);
	    }
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int d = 0; d <4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0|| ny < 0 || nx > N-1|| ny > M-1)
				continue;
			if(!visited[nx][ny] && map[nx][ny]==0) {
				visited[nx][ny] = true;
				dfs(nx,ny);
			}
			
			if(!visited[nx][ny] && map[nx][ny] == 1) {
				map[nx][ny] = 2;
			}
			
		}
		
	}
	static int countCheese() {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 1) cnt++;
        return cnt;
    }
}