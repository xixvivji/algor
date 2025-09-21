import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (line.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}