import java.util.Scanner;
public class Main{
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int year = sc.nextInt();

    if (year < 1 || year > 4000) {
        System.out.println("Invalid input");
        return;
    }
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        System.out.println("1");
    } else {
        System.out.println("0");
    
}
    sc.close();
}
}
