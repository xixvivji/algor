import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s1 = br.readLine();
		String s2= br.readLine();
		
		int res = s1.length();
		s1 = s1.replace(s2, "");
		System.out.println((res - s1.length()) / s2.length());
		
		
	}
}
