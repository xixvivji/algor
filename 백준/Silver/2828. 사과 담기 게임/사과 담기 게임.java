import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(); 
            int M = sc.nextInt(); 
            int J = sc.nextInt();

            int left = 1;         
            int right = M;       

            int count = 0;        

            for (int i = 0; i < J; i++) {
                int apple = sc.nextInt();
                if (apple < left) {
                    count += (left - apple);
                    right -= (left - apple);
                    left = apple;
                }
                
                else if (apple > right) {
                    count += (apple - right);
                    left += (apple - right);
                    right = apple;
                }
            }
            System.out.println(count);
        }
    }