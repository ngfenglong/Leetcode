class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length; 
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++) {
                int val = matrix[i-1][j];
                if(j > 0){
                    val = Math.min(val, matrix[i-1][j-1]);
                }
                if(j < m - 1) {
                    val = Math.min(val, matrix[i-1][j+1]);
                }
                matrix[i][j] += val;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            min = Math.min(min, matrix[n - 1][j]);
        }
        
        return min;
    }
}