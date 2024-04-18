class Solution {
    int[][] grid;
    int m;
    int n;
    int count = 0;
    
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        checkLand();
        return count;
    }
    
    private void checkLand(){
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                if(grid[x][y] == 1){
                    if(x == 0 || grid[x - 1][y] == 0) count++;
                    if(x == m - 1 || grid[x + 1][y] == 0) count++;
                    if(y == 0 || grid[x][y-1] == 0) count++;
                    if(y == n - 1 || grid[x][y + 1] == 0) count++;            
                }
            }
        }
    }
}