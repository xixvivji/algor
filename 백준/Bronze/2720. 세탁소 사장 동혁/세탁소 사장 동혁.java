
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = {25, 10, 5, 1};

        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            for (int coin : coins) {
                int count = money / coin;
                money %= coin;
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
}
