class Solution {
    Set<String> uniquePaths = new HashSet<>();
    public int numDistinctIslands(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    StringBuilder sb = new StringBuilder();
                    traverse(grid, i , j, sb, null);
                    System.out.println(sb.toString());
                    uniquePaths.add(sb.toString());
                }   
            }
        }
        return uniquePaths.size();
    }
    
    
    private void traverse(int[][] grid, int x, int y, StringBuilder sb, Character direction){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0){
            return;
        }
        
        if(direction != null) sb.append(direction);
        grid[x][y] = 0;
        
        // 4 directions
        traverse(grid, x - 1, y, sb, 'U');
        traverse(grid, x + 1, y, sb, 'D');
        traverse(grid, x, y - 1, sb, 'L');
        traverse(grid, x, y + 1, sb, 'R');
        sb.append('0');
    }    
}