
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[] cnt = new long[M];
            long sum = 0;
            long answer = 0;
            cnt[0] = 1; 

            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                sum = (sum + Integer.parseInt(st.nextToken())) % M;
                answer += cnt[(int)sum];
                cnt[(int)sum]++;
            }
            System.out.println(answer);
        }
    }