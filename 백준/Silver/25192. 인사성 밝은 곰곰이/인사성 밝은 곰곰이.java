
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Set<String> set = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if ("ENTER".equals(line)) {
                answer += set.size();
                set.clear();
            } else {
                set.add(line);
            }
        }

        answer += set.size();
        System.out.println(answer);
    }
}