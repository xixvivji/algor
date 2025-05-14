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

/*
import java.util.Stack;
스택사용
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                // 닫는 괄호가 나왔는데 스택이 비어있으면 잘못된 괄호
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop(); // 짝이 맞는 여는 괄호 제거
            }
        }

        // 스택이 비어있으면 모든 괄호가 잘 짝지어진 것
        return stack.isEmpty();
    }
}

 */