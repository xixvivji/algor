import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
	public static int N, M;
	public static int[][] arr;
	public static int[][] prefixSum;
	public static long answer;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    		
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[N][N];
    	prefixSum = new int[N+1][N+1];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=1;i<=N;i++) {
    		for(int j=1;j<=N;j++) {
    			prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i-1][j-1]; 
    		}
    	}
    	
    	
    	for(int t=0;t<M;t++) {
    		st = new StringTokenizer(br.readLine());
    		int i = Integer.parseInt(st.nextToken());
    		int j = Integer.parseInt(st.nextToken());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		System.out.println(prefixSum[x][y] - prefixSum[i-1][y] - prefixSum[x][j-1] + prefixSum[i-1][j-1]);
    		
    	}
    	
    	
	}
}