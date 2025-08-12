
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{i, priority});
                pq.add(priority);
            }

            int printCount = 0;
            while (!queue.isEmpty()) {
                int[] currentDoc = queue.poll();
                
                if (currentDoc[1] == pq.peek()) {
                    printCount++;
                    pq.poll();
                    
                    if (currentDoc[0] == M) {
                        sb.append(printCount).append('\n');
                        break;
                    }
                } else {
                    queue.add(currentDoc);
                }
            }
        }
        System.out.print(sb);
    }
}