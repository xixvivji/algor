import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long res = 1;
        
        for (long i = 1; i <= n; i++) {
            res *= i;
        }
        if(n == 0) {
            System.out.println(1);
        }else
        System.out.println(res);

    }
}