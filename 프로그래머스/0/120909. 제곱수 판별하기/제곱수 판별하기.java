class Solution {
    public int solution(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return 1;
        } else {
            return 2;
        }
    }
}
/*

class Solution {
    public int solution(int n) {
        for (int i = 1; ; i++) {
            int square = i * i;
            if (square == n) return 1;
            if (square > n) break;
        }
        return 2;
    }
}
 */