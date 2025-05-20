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
/*
import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            int distance = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == now) {
                    distance = i - j;
                    break;
                }
            }
            answer.add(distance);
        }

        return answer;
    }
}

 */
/*
import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastIndexMap.containsKey(ch)) {
                answer.add(i - lastIndexMap.get(ch));
            } else {
                answer.add(-1);
            }
            lastIndexMap.put(ch, i);
        }

        return answer;
    }
}

 */
/*
방식 번호	자료구조	핵심 로직	시간복잡도	장점
1	int[]	이중 for문	O(n²)	단순하고 직관적
2	int[]	HashMap	O(n)	빠름, 최적화된 성능
3	List<>	이중 for문	O(n²)	동적 리스트 사용 가능
4	List<>	HashMap	O(n)	빠르고 유연한 리턴 타입
 */