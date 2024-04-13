class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] histogram = new int[m][n];
        int max = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0) {
                        histogram[i][j] = 1;
                    }
                    else{
                        histogram[i][j] = histogram[i - 1][j] + 1;
                    }
                    
                    int height = histogram[i][j];
                    for(int k = j; k >= 0; k--){
                        height = Math.min(height, histogram[i][k]);
                        max = Math.max(max, (j - k + 1) * height);
                    }
                }
            }
        }
        return max;
    }
    

}