import java.util.*;
import java.io.*;


class Main
{
   static int N,M;
    static int[] arr;
    static ArrayList<Integer>[] bigList;
    static ArrayList<Integer>[] smallList;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
      
        
       
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bigList = new ArrayList[N+1];
        smallList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
        	bigList[i] = new ArrayList<>();
        	smallList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i< M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	bigList[a].add(b);
        	smallList[b].add(a);
        }
        int res = 0;
        for(int i = 1; i <=N; i++) {
        	visited = new boolean[N+1];
        	int  cS = countSmall(i);
        	
        	visited = new boolean[N+1];
        	 int cB =countBig(i);
        	 if(cS + cB  == N -1) {
        		 res ++;
        	 }
        }
        System.out.println(res);
        
        
       
        
    }
    
    static int countSmall(int v) {
        int cnt = 0;
        visited[v] = true;
        for (int next : smallList[v]) {
            if (!visited[next]) {
                cnt += 1 + countSmall(next);
            }
        }
        return cnt;
    }


    static int countBig(int v) {
        int cnt = 0;
        visited[v] = true;
        for (int next : bigList[v]) {
            if (!visited[next]) {
                cnt += 1 + countBig(next);
            }
        }
        return cnt;
    }
}