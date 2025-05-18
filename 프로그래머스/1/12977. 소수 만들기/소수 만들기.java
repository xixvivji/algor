class Solution {
    public int solution(int[] nums) {
        int answer = 0;


        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

/*
class Solution {
    int answer = 0;

    public int solution(int[] nums) {
        dfs(nums, 0, 0, 0);
        return answer;
    }

    // DFS로 3개의 숫자 조합
    private void dfs(int[] nums, int index, int count, int sum) {
        if (count == 3) {
            if (isPrime(sum)) {
                answer++;
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            dfs(nums, i + 1, count + 1, sum + nums[i]);
        }
    }

    // 소수 판별 함수
    private boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}

 */
