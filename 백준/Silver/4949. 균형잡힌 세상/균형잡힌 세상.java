import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            if (input.equals(".")) break; // 입력의 끝

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (char ch : input.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isValid = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}