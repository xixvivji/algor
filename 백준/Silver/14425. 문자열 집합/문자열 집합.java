import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashSet<String> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
	
		int count = 0;
		for(int i= 0; i < M; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				count ++;
			}
		}
		System.out.println(count);
	}
}