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

/*
class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();

        for (char ch : my_string.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(Character.toUpperCase(ch));
            }
        }

        return sb.toString();
    }
}

 */