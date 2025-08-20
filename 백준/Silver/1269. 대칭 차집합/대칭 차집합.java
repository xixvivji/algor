
import java.io.*;
import java.util.*;

public class Main {

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());

	        HashSet<Integer> setA = new HashSet<>();
	        HashSet<Integer> setB = new HashSet<>();

	        st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) setA.add(Integer.parseInt(st.nextToken()));
	        st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < M; i++) setB.add(Integer.parseInt(st.nextToken()));

	       
	        int intersection = 0;
	        for (int num : setA) {
	            if (setB.contains(num)) intersection++;
	        }

	        int answer = N + M - intersection * 2;
	        System.out.println(answer);
	    }
	}