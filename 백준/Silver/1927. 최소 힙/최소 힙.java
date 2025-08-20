import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
       
        Queue<Integer> pq = new PriorityQueue<>((o1,o2) -> o1-o2);
        for(int i =0 ; i < N; i++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	if(num == 0 && pq.isEmpty()) {
        		System.out.println(0);
        	}
        	
        	if(num == 0 && !pq.isEmpty()) {
        		System.out.println(pq.poll());
        		
        	}
        	if(num != 0)
        	{
        		pq.add(num);
        	}
        	
        }
  
    }
}