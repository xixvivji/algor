
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static boolean visited[];
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        n = Integer.parseInt(br.readLine());
	        arr = new int[n][n];
	        visited = new boolean[n];
	        for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
	        }
	        for(int i =0; i< n; i++) {
	        	visited[i] = true;
	        	dfs(i,i,0,0);
	        }
	        
	        System.out.println(min);
	        
	    }// main
	    
	    
	    static void dfs(int start,int cur, int depth, int distance) {
	    	if (distance >= min) {
	            return;
	        }
	    	
	    	if(depth == n-1) {
	    		if(arr[cur][start] != 0) {
	    			distance += arr[cur][start];
	    			min = Math.min(min, distance);
	    		}
	    		return;
	    	}
	    	for(int i = 0; i< n; i++) {
	    		if(!visited[i] && arr[cur][i] > 0) {
	    			visited[i] = true;
	    			dfs(start, i , depth+1, distance + arr[cur][i]);
	    			visited[i] = false;
	    		}
	    	}
	    	
	    }
	    
	}