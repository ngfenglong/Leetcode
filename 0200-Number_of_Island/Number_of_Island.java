class Solution {
    public int numIslands(char[][] grid) {
        int numOfIsland = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    updateGrid(grid, i, j);
                    numOfIsland++;
                }
            }
        }
        
        return numOfIsland;
    }
    
    private void updateGrid(char[][] grid, int i, int j){
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        
        if(i > 0) updateGrid(grid, i - 1, j);
        if(j > 0) updateGrid(grid, i, j - 1);
        if(i < grid.length - 1) updateGrid(grid, i + 1, j);
        if(j < grid[0].length - 1) updateGrid(grid, i, j + 1);
    } 
}