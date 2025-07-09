import java.util.Arrays;
class Solution {
    public int solution(int[] array, int n) {
   Arrays.sort(array); 

        int answer = array[0];
        int minDiff = Math.abs(array[0] - n);

        for (int i = 1; i < array.length; i++) {
            int diff = Math.abs(array[i] - n);
            if (diff < minDiff) {
                minDiff = diff;
                answer = array[i];
            }
        }

        return answer;
    }
}
