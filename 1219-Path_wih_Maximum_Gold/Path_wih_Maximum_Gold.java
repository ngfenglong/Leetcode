class Solution {
    int max = 0;
    int m;
    int n;
    int[][] directions = new int[][]{{1,0}, {0,1},{-1, 0},{0, -1}};
    
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    dfs(grid, i, j, new boolean[m][n], 0);
                }
            }
        }
        
        return max;
    }
    
    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int sum){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j]){
            max = Math.max(max, sum);
            return;
        }
        
        sum += grid[i][j];
        visited[i][j] = true;
        for(int[] direction: directions){
            int x = i + direction[0];
            int y = j + direction[1];            
            dfs(grid, x, y, visited, sum);
        }
        visited[i][j] = false;
        sum -= grid[i][j];        
    }
}