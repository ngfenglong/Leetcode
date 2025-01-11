
class MaximumNumberOfMovesInAGrid {
    class Solution {
        int m;
        int n;
        Integer[][] dp;
        
        public int maxMoves(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            dp = new Integer[m][n];
        
            int max = 0;
            for(int i = 0; i < m; i++){
                max = Math.max(max, getMax(grid, i, 0, -1));
            }
            return max;
        }
        
        private int getMax(int[][] grid,  int i, int j, int prevValue){
            if(i < 0  || j < 0 || i >= m || j >= n || prevValue >= grid[i][j]) return -1;
            
            if(dp[i][j] != null) return dp[i][j];
                
            int maxPath = 0;
            
            maxPath = Math.max(maxPath, getMax(grid, i - 1, j + 1, grid[i][j]) + 1);
            maxPath = Math.max(maxPath, getMax(grid, i, j + 1, grid[i][j]) + 1);
            maxPath = Math.max(maxPath, getMax(grid, i + 1, j + 1, grid[i][j]) + 1);
            
            dp[i][j] = maxPath;
            return maxPath;
        }
    }
    
}
