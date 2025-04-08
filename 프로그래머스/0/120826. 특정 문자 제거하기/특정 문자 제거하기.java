class Solution {
    public String solution(String my_string, String letter) {
        return my_string.replace(letter, "");
    }
}
/*
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, String letter) {
        return my_string.chars()  // IntStream
                .mapToObj(c -> String.valueOf((char) c))
                .filter(s -> !s.equals(letter))
                .collect(Collectors.joining());
    }
}
 */

/*
class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) != letter.charAt(0)) {
                sb.append(my_string.charAt(i));
            }
        }
        return sb.toString();
    }
}
 */