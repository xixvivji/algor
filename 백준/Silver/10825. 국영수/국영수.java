
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[][] students = new String[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i][0] = st.nextToken();
            students[i][1] = st.nextToken();
            students[i][2] = st.nextToken(); 
            students[i][3] = st.nextToken();
        }


        Arrays.sort(students, (s1, s2) -> {
         
            int kor1 = Integer.parseInt(s1[1]);
            int kor2 = Integer.parseInt(s2[1]);
            
            if (kor1 != kor2) {
                return kor2 - kor1; 
            }

 
            int eng1 = Integer.parseInt(s1[2]);
            int eng2 = Integer.parseInt(s2[2]);
            
            if (eng1 != eng2) {
                return eng1 - eng2; 
            }

     
            int math1 = Integer.parseInt(s1[3]);
            int math2 = Integer.parseInt(s2[3]);
            
            if (math1 != math2) {
                return math2 - math1;
            }

            
            return s1[0].compareTo(s2[0]);
        });

    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(students[i][0]).append('\n');
        }
        System.out.print(sb);
    }
}