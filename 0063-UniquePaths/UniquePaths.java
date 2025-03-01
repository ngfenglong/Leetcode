public class UniquePaths {
    class Solution {
        int m;
        int n;
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            m = obstacleGrid.length;
            n = obstacleGrid[0].length;
    
            Integer[][] paths = new Integer[m][n];
    
            return getUniquePath(m - 1, n -1, obstacleGrid, paths);
        }
    
        private int getUniquePath(int x, int y, int[][] obstacleGrid, Integer[][] paths){
            if(x < 0 || x >= m || y < 0 || y >= n || obstacleGrid[x][y] == 1) return 0;
    
            if(x == 0 && y == 0) return 1;
    
            if(paths[x][y] != null) return paths[x][y];
    
            int path1 = getUniquePath(x - 1, y, obstacleGrid, paths);
            int path2 = getUniquePath(x, y - 1, obstacleGrid, paths);
    
            paths[x][y] = path1 + path2;
            return paths[x][y];
        }
    }    
}