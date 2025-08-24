import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int result = 0;
        int patternCount = 0;

        for (int i = 0; i <= M - 3; ) {
            if (S[i] == 'I' && S[i + 1] == 'O' && S[i + 2] == 'I') {
                patternCount++; 

                if (patternCount == N) {
                    result++; 
                    patternCount--;
                }
                i += 2;
            } else {
                patternCount = 0;
                i++;
            }
        }

        System.out.println(result);
    }
}