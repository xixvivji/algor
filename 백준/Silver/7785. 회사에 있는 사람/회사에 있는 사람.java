
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if (cmd.equals("enter")) {
                set.add(name);
            } else { // "leave"
                set.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : list) {
            sb.append(name).append('\n');
        }
        System.out.print(sb.toString());
    }
}