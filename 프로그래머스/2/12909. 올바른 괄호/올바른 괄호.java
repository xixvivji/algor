class Solution {
    boolean solution(String s) {
        int count = 0; // '('를 +1, ')'를 -1

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            // ')'가 먼저 나오면 잘못된 괄호
            if (count < 0) {
                return false;
            }
        }

        // 모든 '('가 닫혔는지 확인
        return count == 0;
    }
}
