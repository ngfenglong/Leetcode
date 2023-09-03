class Solution {
    Integer[][] dp;
    
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        
        return dfs(0,0,m,n);
    }
    
    
    private int dfs(int i, int j, int m, int n) {
        if(i >= m || j >= n) return 0;
        
        if(i == m - 1 && j == n-1){
            return 1;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        
        dp[i][j] = dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
        return dp[i][j];
    }
    
}