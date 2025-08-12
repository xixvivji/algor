import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int printCount = 0;
            while (!queue.isEmpty()) {
                int[] currentDoc = queue.poll(); 
                boolean isPrintable = true;

                for (int[] docInQueue : queue) {
                    if (docInQueue[1] > currentDoc[1]) {
                        isPrintable = false;
                        break;
                    }
                }

                if (isPrintable) {
                    printCount++;
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