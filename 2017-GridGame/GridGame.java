class GridGame{
    class Solution {
        public long gridGame(int[][] grid) {
            long firstRowSum = 0l;
            long secondRowSum= 0l;
            long ans = Long.MAX_VALUE;
    
            for(int i = 0; i < grid[0].length; i++){
                firstRowSum += (long)grid[0][i];
            }
    
            for(int i = 0; i < grid[0].length; i++){
                if(i > 0) secondRowSum += (long)grid[1][i - 1];
                
                firstRowSum -= (long)grid[0][i];
    
                ans = Math.min(ans, Math.max(firstRowSum, secondRowSum));
            }
    
            return ans;
        }
    }
}
