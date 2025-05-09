import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // ✅ 오타 수정

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.add(number);
                maxHeap.add(number);
            } else if (command.equals("D")) {
                if (minHeap.isEmpty()) continue;

                if (number == 1) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else if (number == -1) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}
