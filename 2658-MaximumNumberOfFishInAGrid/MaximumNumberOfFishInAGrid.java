class MaximumNumberOfFishInAGrid{
    class Solution {
        int m;
        int n;
        public int findMaxFish(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
    
            boolean[][] visited = new boolean[m][n];
            int ans = 0;
    
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    int max = catchFishes(i, j, visited, grid);
                    ans = Math.max(max, ans);
                }
            }
    
            return ans;
        }
    
    
        private int catchFishes(int i, int j, boolean[][] visited, int[][] grid){
            if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0 || visited[i][j]) return 0;
    
            visited[i][j] = true;
        
            return (
                grid[i][j] + 
                catchFishes(i + 1, j, visited, grid) + 
                catchFishes(i - 1, j, visited, grid) + 
                catchFishes(i, j + 1, visited, grid) + 
                catchFishes(i, j - 1, visited, grid)
            );
        }
    }
}
