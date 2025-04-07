import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.add(work);
        }

        while (n > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if (max > 0) {
                pq.add(max - 1);
            }
            n--;
        }

        long result = 0;
        while (!pq.isEmpty()) {
            int remain = pq.poll();
            result += (long) remain * remain;
        }

        return result;
    }
}
