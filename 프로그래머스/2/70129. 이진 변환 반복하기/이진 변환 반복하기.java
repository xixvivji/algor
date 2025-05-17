class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            int ones = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') ones++;
                else zeroCount++;
            }

            s = Integer.toBinaryString(ones);
            count++;
        }

        return new int[] {count, zeroCount};
    }
}
