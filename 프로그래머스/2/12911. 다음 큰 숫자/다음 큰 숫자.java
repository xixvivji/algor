class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n); // 현재 숫자의 1의 개수
        int next = n + 1;

        while (Integer.bitCount(next) != count) {
            next++;
        }

        return next;
    }
}

// -> 숫자 ***을 n진수로 변환후 x의 개수를 세는 방법
//int n = 78;
//String base3 = Integer.toString(n, 3); // 78을 3진수 문자열로 변환
//long countOnes = base3.chars().filter(c -> c == '1').count(); // '1' 개수 세기

//public static int countDigitInBase(int n, int base, int digit) {
//    int count = 0;
//    while (n > 0) {
//        if (n % base == digit) {
//            count++;
//        }
//        n /= base;
//    }
//    return count;
//}
