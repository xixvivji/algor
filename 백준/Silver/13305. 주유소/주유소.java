
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] len = new long[N - 1];	
        long[] point = new long[N];	 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++) {
            len[i] = Long.parseLong(st.nextToken());
        }

       
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            point[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = point[0];	

        for(int i = 0; i < N - 1; i++) {

            if(point[i] < minCost) {
                minCost = point[i];
            }

            sum += (minCost * len[i]);
        }

        System.out.println(sum);

    }
}