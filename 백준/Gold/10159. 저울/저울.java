
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] upList;
    static ArrayList<Integer>[] downList;
    static int N, M;
    static int [] dist;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        upList = new ArrayList[N+1];
        downList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0 ; i <= N ; i++) {
        	upList[i] = new ArrayList<>();
        	downList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	upList[a].add(b);
        	downList[b].add(a);
        }
        
        for(int i = 1; i <= N; i++) {
        	visited = new boolean[N+1];
        	int u  = countUp(i);
         	visited = new boolean[N+1];
         	int d = countDown(i);
         	
         	System.out.println(N - u - d -1);
        }
    }
    
    
    static int countUp(int i) {
    	int cnt = 0;
    	visited[i] = true;
    	for(int n : upList[i]) {
    		if(!visited[n]) {
    			cnt+= 1 + countUp(n);
    		}
    	}
    	return cnt;
    }
    
    
    static int countDown(int i) {
    	int cnt = 0;
    	visited[i] = true;
    	for(int n : downList[i]) {
    		if(!visited[n]) {
    			cnt+= 1 + countDown(n);
    		}
    	}
    	return cnt;
    }
    
    
}