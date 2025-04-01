class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;       
        int col = arr2[0].length;    
        int n = arr1[0].length;      
        
        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}