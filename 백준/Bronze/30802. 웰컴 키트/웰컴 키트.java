import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static boolean[] prime ;
    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int [] t = new int [6];
     int T = 0;
     int P = 0;
     int p = 0;	
     StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++){
            t[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t.length; i++) {
            if(t[i] % a != 0){
                T += t[i] /a  + 1;
            }
            else
            T += t[i] / a;
        }

        P = N / b;
        p = N % b;
        System.out.println(T);
        System.out.println(P + " " +p);
		
	}
}
 