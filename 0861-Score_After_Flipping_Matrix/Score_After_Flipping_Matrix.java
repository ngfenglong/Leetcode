class Solution {
    public int matrixScore(int[][] grid) {
        // Check the first element of all rows --> For the biggest possible number for each row
        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] != 1){
                flipRow(grid, i);
            }
        }
        
        for(int j = 1; j < grid[0].length; j++){
            int count = 0;
            for(int i = 0; i < grid.length; i++){
                if(grid[i][j] == 1) count++;                
            }
            
            if(count < (grid.length + 1) / 2){
                flipCol(grid, j);
            }            
        }
        
        return calculateGrid(grid);
        
    }
    
    private void flipRow(int[][] grid, int row){
        for(int j = 0; j < grid[0].length; j++){
            grid[row][j] = 1 - grid[row][j];
        }
    }
    
     private void flipCol(int[][] grid, int col){
        for(int i = 0; i < grid.length; i++){
            grid[i][col] = 1 - grid[i][col];
        }
    }
    
    private int calculateGrid(int[][] grid){
        int total = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    total += (Math.pow(2, (n - j - 1)));
                }
            }
        }
        return total;
    }
}