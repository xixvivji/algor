
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (X > 0) {
            cnt += (X & 1); 
            X >>= 1;        
        }
        System.out.println(cnt);
    }
}