import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		N /= 100;
		N *= 100;
		int F = Integer.parseInt(br.readLine());
		
		int res = 0;
		while(N % F != 0) {
			N++;
			res ++;
		}
		if(res < 10) {
			System.out.println("0" + res);
		}
		else {
			System.out.println(res);
		}
		
	}
}
