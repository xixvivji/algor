
import java.util.Scanner;

class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(isFindNumber(N));


    }

    public static boolean isPalindrome(int n) {
        String str = String.valueOf(n);
        return str.contentEquals(new StringBuilder(str).reverse());
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int isFindNumber(int n) {
        for (int i = n; ; i++) {
            if (isPrimeNumber(i) && isPalindrome(i)) {
                return i;
            }
        }

    }
}