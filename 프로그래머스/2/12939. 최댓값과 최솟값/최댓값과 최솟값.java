import java.util.*;

class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" "); 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String num : numbers) {
            int value = Integer.parseInt(num); 
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        
        return min + " " + max;
    }
}
