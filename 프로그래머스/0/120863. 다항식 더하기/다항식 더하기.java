class Solution {
    public String solution(String polynomial) {
        String[] terms = polynomial.split(" \\+ ");
        int xSum = 0;
        int numSum = 0;

        for (String term : terms) {
            if (term.contains("x")) {
                // x항이지만 계수가 생략된 경우 (예: "x")
                if (term.equals("x")) {
                    xSum += 1;
                } else {
                    xSum += Integer.parseInt(term.replace("x", ""));
                }
            } else {
                numSum += Integer.parseInt(term);
            }
        }

        StringBuilder result = new StringBuilder();

        // x항 조립
        if (xSum != 0) {
            if (xSum == 1) {
                result.append("x");
            } else {
                result.append(xSum).append("x");
            }
        }

        // 상수항 조립
        if (numSum != 0) {
            if (xSum != 0) {
                result.append(" + ");
            }
            result.append(numSum);
        }

        return result.toString();
    }
}
