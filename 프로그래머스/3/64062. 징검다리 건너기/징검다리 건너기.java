class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;                     
        int right = 200_000_000;           

        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(stones, k, mid)) {
                answer = mid;            
                left = mid + 1;
            } else {
                right = mid - 1;     
            }
        }

        return answer;
    }

    // mid 명이 건널 수 있는가?
    private boolean canCross(int[] stones, int k, int people) {
        int skip = 0;

        for (int stone : stones) {
            if (stone - people < 0) {
                skip++;
                if (skip >= k) return false;  
            } else {
                skip = 0;  
            }
        }

        return true;
    }
}