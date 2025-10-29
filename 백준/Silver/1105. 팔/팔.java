

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int cnt = 0;

       
        if (s1.length() != s2.length()) {
            System.out.println(0);
            return;
        }
        
       
        for (int i = 0; i < s1.length(); i++) {
            char s1_char = s1.charAt(i);
            char s2_char = s2.charAt(i);

           
            if (s1_char != s2_char) {
                break;
            }

      
            if (s1_char == '8') {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}