
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		for(int i = -1000; i <= 1000; i++) {
			if(i*i + i*A*2 + B == 0) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb.toString());
		
	}
}
