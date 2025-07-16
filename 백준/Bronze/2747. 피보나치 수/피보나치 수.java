import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(long n) {
        if (n <= 2) return 1;

        long a = 1, b = 1, next = 0;
        for (int i = 3; i <= n; i++) {
            next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}