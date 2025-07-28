import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 명령의 개수
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                stack.push(num);
            } else if (cmd.equals("pop")) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("top")) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }
        }
        System.out.print(sb);
    }
}