import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(num);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }
        System.out.println(sum);
    }
}
