class Solution {
    
  
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
      
        int greatestCommonDivisor = gcd(n, m);
        int leastCommonMultiple = lcm(n, m);
        
    
        answer[0] = greatestCommonDivisor;
        answer[1] = leastCommonMultiple;
        
        return answer;
    }

}