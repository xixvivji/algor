import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); 
        
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] srr = new String[N];

            for (int i = 0; i < N; i++) {
            	srr[i] = br.readLine();
            }

           
            Arrays.sort(srr);

            
            boolean isContain = true;

           
            for (int i = 0; i < N - 1; i++) {
              
                if (srr[i+1].startsWith(srr[i])) {
                	isContain = false; 
                    break; 
                }
            }

    
            if (isContain) {
               System.out.println("YES");
            } else {
               System.out.println("NO");
            }
        }
        
   
    }
}