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
/*
항목	카운팅 방식	스택 방식
공간 복잡도	O(1)	O(N)
시간 복잡도	O(N)	O(N)
간결함	✅ 더 간결하고 빠름	❌ 상대적으로 복잡
유연성	❌ 괄호 종류 많으면 복잡	✅ 다양한 괄호 쌍 처리 가능
 */
/*
여러종류괄호
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 여는 괄호일 경우 스택에 push
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 닫는 괄호일 때 스택이 비어있으면 false
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                // 짝이 맞는지 확인
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // 모두 처리하고 스택이 비어있어야 올바른 괄호
        return stack.isEmpty();
    }
}

 */