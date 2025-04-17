class Solution {
    public int solution(int[] array) {
        int[] count = new int[1000];


        for (int num : array) {
            count[num]++;
        }

        int maxCount = 0;
        int mode = -1;
        boolean isDuplicate = false;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mode = i;
                isDuplicate = false;
            } else if (count[i] == maxCount && count[i] != 0) {
                isDuplicate = true;
            }
        }

        return isDuplicate ? -1 : mode;
    }
}
/*
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // 1. 각 숫자의 등장 횟수 세기
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 2. 최빈값 찾기
        int maxCount = 0;
        int mode = -1;
        boolean isDuplicate = false;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxCount) {
                maxCount = value;
                mode = key;
                isDuplicate = false;
            } else if (value == maxCount) {
                isDuplicate = true;
            }
        }

        return isDuplicate ? -1 : mode;
    }
}

 */