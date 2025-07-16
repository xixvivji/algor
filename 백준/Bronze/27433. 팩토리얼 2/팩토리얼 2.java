import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        //if(n < 0 || n >20)
          //  throw new IllegalArgumentException();
        sc.close();
        System.out.println(factorial(n));
    }
    public static long factorial(long n) {
        if (n == 0)
            return 1;
        return n * factorial(n-1);
    }

}