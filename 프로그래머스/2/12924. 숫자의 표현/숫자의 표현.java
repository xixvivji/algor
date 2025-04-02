class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n / 2; i++) {
            int sum = i;
            for (int j = i + 1; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (sum > n) break;
            }
        }
        return answer + 1; 
    }
}