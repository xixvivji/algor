
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String s = br.readLine();
            if (s == null) s = "";
            s = s.trim();

            int cnt = 0;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'O') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                res += cnt;
            }
            System.out.println(res);
        }
    }
}