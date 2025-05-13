import java.util.*;

class Solution { // greedy + 정렬
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();


        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>(countMap.values());
        countList.sort(Collections.reverseOrder());


        int sum = 0;
        int kind = 0;
        for (int count : countList) {
            sum += count;
            kind++;
            if (sum >= k) {
                break;
            }
        }

        return kind;
    }
}
