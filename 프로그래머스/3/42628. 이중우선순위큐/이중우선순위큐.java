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
                if (minHeap.isEmpty()) {
                    continue;
                }

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
            return new int[] {0, 0};
        } else {
            return new int[] {maxHeap.peek(), minHeap.peek()};
        }
    }
}

/*

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                map.put(number, map.getOrDefault(number, 0) + 1);
            } else if (command.equals("D")) {
                if (map.isEmpty()) continue;

                int key = (number == 1) ? map.lastKey() : map.firstKey();
                int count = map.get(key);
                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, count - 1);
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}
firstKey()는 최솟값, lastKey()는 최댓값을 빠르게 찾을 수 있는 메서드
값의 개수를 Map<Integer, Integer>로 관리하므로 중복된 숫자도 정확히 처리
 */
