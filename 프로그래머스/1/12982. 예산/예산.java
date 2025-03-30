import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        
        for (int sum : d) {
            if (budget >= sum) {
                budget -= sum;
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
}
