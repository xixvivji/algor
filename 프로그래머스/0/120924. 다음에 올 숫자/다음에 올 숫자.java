class Solution {
    public int solution(int[] common) {
        int ans = 0;
        if (common[2] - common[1] == common[1] - common[0]){
            ans = common[common.length-1] + (common[1] - common[0]);
        }else 
            ans = common[common.length-1] * (common[1] / common[0]);
        return ans;
    }
}