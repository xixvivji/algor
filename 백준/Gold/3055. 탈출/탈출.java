
import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static char[][] map;
    static boolean visited[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};    
    static Queue<node1> q1 = new LinkedList<>(); // 물
    static Queue<node2> q2 = new LinkedList<>(); // 고슴도치
    static int res = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++) {
        	String line = br.readLine();
        	for(int j = 0; j < C; j++) {
        		map[i][j] = line.charAt(j);
        		if(map[i][j] == 'S') {
        			q2.add(new node2(i,j,0));
        		}
        		if(map[i][j] == '*') {
        			q1.add(new node1(i,j));
        		}
        	}
        	
        }
        bfs();
        System.out.println(res == Integer.MAX_VALUE ? "KAKTUS" : res);
        
        
    
    }// main
    
    static void bfs() {
        while(!q2.isEmpty()) {
          
            int wsize = q1.size();
            for(int i = 0; i < wsize; i++) {
                node1 n1 = q1.poll();
                for(int d = 0; d < 4; d++) {
                    int nx = n1.x + dx[d];
                    int ny = n1.y + dy[d];
                    if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if(map[nx][ny] == '.') {
                            map[nx][ny] = '*';
                            q1.add(new node1(nx, ny));
                        }
                    }
                }
            }
            
            int hsize = q2.size();
            for(int i = 0; i < hsize; i++) {
                node2 n2 = q2.poll();
                for(int d = 0; d < 4; d++) {
                    int nx = n2.x + dx[d];
                    int ny = n2.y + dy[d];
                    if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if(map[nx][ny] == 'D') {
                            res = n2.time + 1;
                            return;
                        }
                        if(map[nx][ny] == '.' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q2.add(new node2(nx, ny, n2.time + 1));
                        }
                    }
                }
            }
        }
    }
    
    
    static class node1{
    	int x;
    	int y;
    	node1(int x, int y){
    		this.x = x;
    		this.y = y;
    		
    	}
    }
  
    
    
    static class node2{
    	int x;
    	int y;
    	int time;
    	node2(int x, int y,int time){
    		this.x = x;
    		this.y = y;
    		this.time = time;
    		
    	}
    }
    
}