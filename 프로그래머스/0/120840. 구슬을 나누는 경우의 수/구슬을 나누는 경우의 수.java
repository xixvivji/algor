class Solution {
    public long solution(int balls, int share) {
        return combination(balls, share);
    }

    private long combination(int n, int r) {
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result *= (n - i + 1);
            result /= i;
        }
        return result;
    }
}
