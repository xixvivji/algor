import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
       
        Queue<Integer> pq = new PriorityQueue<>((o1,o2) -> o1-o2);
        for(int i =0 ; i < N; i++) {
        	pq.add(Integer.parseInt(br.readLine()));
        }
        
        int sum = 0;
        while(!pq.isEmpty()) {
			if(pq.size()==1) break;
			
			int a = pq.poll();
			int b=  pq.poll();
			sum += (a+b);
			pq.add(a+b);
		}
        
        System.out.println(sum);
    }
}