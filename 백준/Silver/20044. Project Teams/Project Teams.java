import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int [N*2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i <arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		
		}
		Arrays.sort(arr);
		
		int sumArr[] =new int[N];
		
		for(int i = 0 ; i < N; i++) {
			sumArr[i] = arr[i] + arr[N*2-i-1];
		}
		Arrays.sort(sumArr);
		System.out.println(sumArr[0]);
	}

}
