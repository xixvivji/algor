class Solution {
    public int solution(int[] array) {
        int[] count = new int[1000]; 

    
        for (int num : array) {
            count[num]++;
        }

        int maxCount = 0;
        int mode = -1;
        boolean isDuplicate = false;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mode = i;
                isDuplicate = false;
            } else if (count[i] == maxCount && count[i] != 0) {
                isDuplicate = true;
            }
        }

        return isDuplicate ? -1 : mode;
    }
}