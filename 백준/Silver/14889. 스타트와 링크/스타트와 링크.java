
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int [][]arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
      N = Integer.parseInt(br.readLine());
      arr= new int[N][N];
      visited = new  boolean[N];
      
      for (int i = 0; i < arr.length; i++) {
    	st = new StringTokenizer(br.readLine());
    	for (int j = 0; j < arr[i].length; j++) {
    		arr[i][j] = Integer.parseInt(st.nextToken()); 
		}
	}
      
      dfs(0,0);
      System.out.println(min);
    }

    
    
    static void dfs(int start, int depth) {
      
    	if(depth == N/2) {
    		calDiff();
    		return;
    	}
    	
    	for(int i =start; i < N; i++ ) {
    		
    	if(!visited[i]) {
    		visited[i] =true;
    		dfs(i+1, depth+1);
    		visited[i]= false;
    		
    		}
    	}
    	
    
    	
    }
    
	static void calDiff() {
		int start =0;
		int link = 0;
		
		
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if(visited[i] == true && visited[j] == true) {
					start += arr[i][j];
					start += arr[j][i];
				}
				else if(visited[i] == false && visited[j] == false)
				{
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		int dif = Math.abs(start - link);
		
		
		if(dif == 0) {
			System.out.println(dif);
			System.exit(0);
		}
		
		min = Math.min(dif,min);
	}
	
}