class Solution {
    public int solution(String str1, String str2) {
        if (str1.contains(str2)) {
            return 1;
        } else {
            return 2;
        }
    }
}
/*
class Solution {
    public int solution(String str1, String str2) {
        if (str1.indexOf(str2) != -1) {
            return 1;
        } else {
            return 2;
        }
    }
}

 */

/*
class Solution {
    public int solution(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = 0; i <= len1 - len2; i++) {
            boolean match = true;
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) return 1;
        }

        return 2;
    }
}
 */