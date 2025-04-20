class Solution {
    public int solution(int n) {
        int factorial = 1;
        int i = 1;

        while (true) {
            factorial *= i;
            if (factorial > n) {
                return i - 1;
            }
            i++;
        }
    }
}
