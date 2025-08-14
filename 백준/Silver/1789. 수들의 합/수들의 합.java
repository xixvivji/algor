
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long S = Long.parseLong(br.readLine());
        long i =1;
        int count = 0;
        while (true) {
        S = S-i;
        i++;
        count ++;
        if(S < i){
            break;
        }
      }

        System.out.println(count);

	}
}