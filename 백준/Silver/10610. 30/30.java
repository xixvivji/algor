import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
		 Scanner sc =new Scanner(System.in);
		 String s = sc.next();
		 
		   if (!s.contains("0")) {
	            System.out.println(-1);
	            return;
	        }

	        int sum = 0;
	        for (int i = 0; i < s.length(); i++) {
	            sum += s.charAt(i) - '0'; 
	        }

	        if (sum % 3 != 0) {
	            System.out.println(-1);
	            return;
	        }


	        char[] arr = s.toCharArray();
	        Arrays.sort(arr);
	        for (int i = arr.length - 1; i >= 0; i--) {
	            System.out.print(arr[i]);
	        }
	    }
	}