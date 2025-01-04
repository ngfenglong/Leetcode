import java.util.*;
class Solution {
    
    int m;
    int n;
    public int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;
        List<int[]> ans = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    int[] bottomRight = new int[]{i,j,i,j};
                    checkFarmLand(land, i,j, visited, bottomRight);
                    ans.add(bottomRight);
                }
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
    
    private void checkFarmLand(int[][] land, int x, int y, boolean[][] visited, int[] bottomRight){
        if(x >= m || y >= n || visited[x][y] || land[x][y] == 0) return;
        
        visited[x][y] = true;
        if(x == m - 1 || land[x + 1][y] == 0){
            bottomRight[2] = x;
        }
        else{
            checkFarmLand(land, x + 1, y, visited, bottomRight);
        }
        
        if(y == n - 1 || land[x][y + 1] == 0){
            bottomRight[3] = y;
        }
        else{
            checkFarmLand(land, x, y + 1, visited, bottomRight);
        }
        
    }
}