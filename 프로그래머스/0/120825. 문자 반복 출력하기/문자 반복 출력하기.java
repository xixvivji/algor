class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            for (int j = 0; j < n; j++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

/*

import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int n) {
        return my_string.chars()
                .mapToObj(c -> String.valueOf((char) c).repeat(n))
                .collect(Collectors.joining());
    }
}
 */