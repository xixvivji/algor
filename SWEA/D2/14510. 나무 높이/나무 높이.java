
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
	
		
		for(int tc =1; tc <= T; tc++) {
			int N =Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			
			int max = 0;
			for(int i = 0 ; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
		
			int one = 0;
			int two =0;
			for(int i = 0; i< N; i++) {
				int diff = max - arr[i];
				if(diff == 0) continue;
				two += diff /2;
				one += diff %2;
				
			}
			
			
			if(two > one) {
				while(Math.abs(two - one) > 1) {
					two --;
					one += 2;
				}
			}
			int res = 0;
			if(two > one) {
				res = two * 2;
			}
			else if( two < one ) {
				res = one * 2 -1;
			}
			else {
				res = one +two;
			}
		
			System.out.println("#"+tc + " " + res);
			
			
			
		}
			
    }
}