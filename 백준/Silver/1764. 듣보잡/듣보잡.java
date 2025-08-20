import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				list.add(str);
			}

		}

		Collections.sort(list);

		System.out.println(list.size());

		for (String s : list) {
			System.out.println(s);
		}
	}

}