import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] patterns = {
            {10},                 
            {1},                
            {2, 4, 8, 6},       
            {3, 9, 7, 1},       
            {4, 6},             
            {5},               
            {6},               
            {7, 9, 3, 1},       
            {8, 4, 2, 6},     
            {9, 1},             
            {10}               
        };

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int lastDigit = a % 10;
            int[] pattern = patterns[lastDigit];
            int len = pattern.length;

            int index = (b - 1) % len;
            int result = pattern[index];

            System.out.println(result == 10 ? 10 : result);
        }
    }
}
