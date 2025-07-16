import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        //if(n < 0 || n >20)
          //  throw new IllegalArgumentException();
        sc.close();
        System.out.println(fibonacci(n));
    }
    public static long fibonacci(long n) {
        if (n < 2)
            return n;
        return fibonacci(n - 1) + fibonacci(n- 2 );
    }

}