import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> book = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            book.put(s, book.getOrDefault(s, 0) + 1);
        }

        String best = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : book.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                best = entry.getKey();
            }
        }
        System.out.println(best);
    }
}