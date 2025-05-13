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

/*
import java.util.*;

class Solution { // priority queue 사용
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int t : tangerine) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }

        // 우선순위 큐를 사용하여 개수 기준으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(countMap.values());

        int total = 0;
        int kinds = 0;

        while (total < k && !pq.isEmpty()) {
            total += pq.poll();
            kinds++;
        }

        return kinds;
    }
}

방식	시간 복잡도	특징	일반적인 속도
Map + 정렬	O(N + M log M)
※ N은 tangerine 길이, M은 종류 수	정렬 연산 추가	대부분의 경우 더 빠름
PriorityQueue	O(N + M log M)
우선순위 큐 삽입과 제거 포함	코드 간결, 직관적	약간 느릴 수 있음 (힙 연산 overhead)


 */
