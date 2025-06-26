import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        sc.close();

        String[] cr = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        for (String str : cr) {
            word = word.replace(str, "1"); 
        }

        System.out.println(word.length()); 
    }
}