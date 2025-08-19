
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 
		 int N = Integer.parseInt(st.nextToken());
		 int L = Integer.parseInt(st.nextToken());
		 int[] arr = new int [N];
		 
		 st = new StringTokenizer(br.readLine());
		 for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		 Arrays.sort(arr);
		 int count = 1;
		 double tape = (arr[0] - 0.5) + L;
		 for(int i = 1; i< N; i++) {
			 if(tape < arr[i] + 0.5) {
				 count++;
				 tape = arr[i] - 0.5 + L;
			 }
		 }
		 System.out.println(count);
		}
			
	}