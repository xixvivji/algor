import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner (System.in);
      int N = sc.nextInt();
      Queue<Integer> q1 = new LinkedList<>();
      for (int i = 1; i <= N; i++) {
          q1.add(i);

      }
      while (q1.size() > 1) {
          q1.poll();
          q1.add(q1.poll());
      }
        System.out.println(q1.poll());
    }
}