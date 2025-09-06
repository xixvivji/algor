

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] pack = new int[M];
        int[] div = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            div[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pack); 
        Arrays.sort(div);  
        int onlyPack = pack[0] * ((N + 5) / 6);

        int packAndDiv = pack[0] * (N / 6) + div[0] * (N % 6);

        int onlyDiv = N * div[0];

        
        int res = Math.min(onlyPack, Math.min(packAndDiv, onlyDiv));
        System.out.println(res);
    }
}