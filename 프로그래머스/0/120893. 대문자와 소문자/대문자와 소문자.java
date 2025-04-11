class Solution {
    public String solution(String my_string) {
        return my_string.chars()
            .mapToObj(c -> {
                char ch = (char) c;
                if (Character.isUpperCase(ch)) {
                    return Character.toLowerCase(ch);
                } else {
                    return Character.toUpperCase(ch);
                }
            })
            .collect(StringBuilder::new,
                     StringBuilder::append,
                     StringBuilder::append)
            .toString();
    }
}