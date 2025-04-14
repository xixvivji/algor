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
/*
import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        return combination(balls, share).intValue();
    }

    private BigInteger combination(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }

    // 재귀로 팩토리얼 구현
    private BigInteger factorial(int num) {
        if (num <= 1) return BigInteger.ONE;
        return BigInteger.valueOf(num).multiply(factorial(num - 1));
    }
}
 */