import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastIndexMap.containsKey(ch)) {
                answer[i] = i - lastIndexMap.get(ch);
            } else {
                answer[i] = -1;
            }
            lastIndexMap.put(ch, i);
        }

        return answer;
    }
}

/*
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    answer[i] = i - j;
                    found = true;
                    break;
                }
            }
            if (!found) {
                answer[i] = -1;
            }
        }

        return answer;
    }
}

 */