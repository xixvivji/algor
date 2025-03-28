class Solution {
    public int solution(int n) {
        int mod = 1234567;
        int f1 = 0, f2 = 1;

        for (int i = 2; i <= n; i++) {
            int next = (f1 + f2) % mod;
            f1 = f2;
            f2 = next;
        }

        return f2;
    }
}