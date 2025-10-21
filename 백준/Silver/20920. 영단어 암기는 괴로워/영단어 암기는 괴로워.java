
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            if (s.length() < M) continue; 
            map.put(s, map.getOrDefault(s, 0) + 1); 
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            int cntA = map.get(a);
            int cntB = map.get(b);
            if (cntA != cntB) return Integer.compare(cntB, cntA);    
            if (a.length() != b.length()) return Integer.compare(b.length(), a.length());
            return a.compareTo(b); 
        });

        StringBuilder sb = new StringBuilder();
        for (String w : list) sb.append(w).append('\n');
        System.out.print(sb.toString());
    }
}