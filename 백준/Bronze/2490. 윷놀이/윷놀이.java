
import java.io.IOException;
import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 3; t++) {
            int zero = 0;
            for (int i = 0; i < 4; i++) {
                int x = sc.nextInt();
                if (x == 0) zero++;
            }
            switch (zero) {
                case 0:
                    System.out.println("E");
                    break;
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                case 4:
                    System.out.println("D");
                    break;
            }
        }
    }
}