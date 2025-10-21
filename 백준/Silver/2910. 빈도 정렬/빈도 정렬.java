import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer("");
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIdx = new HashMap<>();
        List<Integer> order = new ArrayList<>();
        int count = 0;
        while (count < N) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (!freq.containsKey(x)) {
                freq.put(x, 1);
                firstIdx.put(x, order.size());
                order.add(x);
            } else {
                freq.put(x, freq.get(x) + 1);
            }
            count++;
        }

        List<Integer> keys = new ArrayList<>(order);
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < order.size(); i++) idxMap.put(order.get(i), i);

        Collections.sort(keys, (a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);
            if (fa != fb) return Integer.compare(fb, fa); 
            return Integer.compare(idxMap.get(a), idxMap.get(b)); 
        });

        StringBuilder sb = new StringBuilder();
        for (int k : keys) {
            int f = freq.get(k);
            for (int i = 0; i < f; i++) {
                sb.append(k).append(' ');
            }
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}