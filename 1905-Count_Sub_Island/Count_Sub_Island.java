class Solution {
    int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subland = 0;
        
        for(int i = 0; i < grid1.length; i++){
            for(int j = 0; j < grid1[0].length; j++){
                if(grid2[i][j] == 1){
                    if(checkLand(grid2, i, j, grid1)){
                        subland++;
                    }
                }
            }
        }
        
        return subland;
    }
    
    
    private boolean checkLand(int[][] grid, int i, int j, int[][] islandCheck){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return true;
        }
        
        boolean isSubIsland = (islandCheck[i][j] == 1);
        grid[i][j] = 0;
        
        for(int[] direction : DIRECTIONS){
            isSubIsland = checkLand(grid, i + direction[0], j + direction[1], islandCheck) && isSubIsland;
        }
        
        return isSubIsland;
    }
}