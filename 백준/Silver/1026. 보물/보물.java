
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        ArrayList<Integer> b= new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
           b.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += a[i] * Collections.max(b);
            b.remove(Collections.max(b));
        }
        System.out.println(sum);

	}
}