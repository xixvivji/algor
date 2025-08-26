import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
public class Main {
	

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       long n = Long.parseLong(br.readLine());
     
       if (n %2 == 1) {
           System.out.print("SK");
       } else {
           System.out.print("CY");
       }
       
    }
}