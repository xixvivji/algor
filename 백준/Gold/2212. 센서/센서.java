import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int arr[] = new int [N];
       
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int sum =0;
        int [] diff = new int [N-1];
        for (int i = 0; i < diff.length; i++) {
			diff[i] = arr[i+1] - arr[i];
		}
        
        Arrays.sort(diff);
        
        for(int i = 0 ; i < N- K; i++) {
        	sum += diff[i];
        }
        System.out.println(sum);
        
    }
}