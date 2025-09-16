import java.io.*;

public class Main {
    static long pow(long base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long answer = 0;
        for (int i = 0; N > 0; i++) {
            if ((N & 1) == 1) {
                answer += pow(3, i);
            }
            N >>= 1;
        }
        System.out.println(answer);
    }
}