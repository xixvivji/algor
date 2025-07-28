import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = -1; 

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                queue.offer(num);
                last = num;
            } else if (cmd.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
            } else if (cmd.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : last).append('\n');
            }
        }
        System.out.print(sb);
    }
}