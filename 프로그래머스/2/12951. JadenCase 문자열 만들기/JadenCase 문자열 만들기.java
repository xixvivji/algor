class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.toLowerCase().split(" ", -1);
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            }
        }
        
        return String.join(" ", words);
    }
}