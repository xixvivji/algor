import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int res = 0;

        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            sum += num;
            if (Math.abs(100 - sum) <= Math.abs(100 - res)) {
                res = sum;
            }
        }
        System.out.println(res);
    }
}