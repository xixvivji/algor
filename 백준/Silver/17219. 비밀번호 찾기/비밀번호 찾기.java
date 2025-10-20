
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

      
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<N; i++) {
        	st= new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String password = st.nextToken();
            map.put(url, password);
           
        }
 
        StringBuilder sb = new StringBuilder(M);
        for(int i=0; i<M; i++) {
            sb.append(map.get(br.readLine()) + "\n");
        }
        System.out.print(sb);
    }
}