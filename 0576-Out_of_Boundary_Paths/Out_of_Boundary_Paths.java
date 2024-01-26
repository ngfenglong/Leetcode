class Solution {
    int m;
    int n;
    int MODULO = 1000000007;
    int[][] directions = new int[][]{ new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        Integer[][][] memo = new Integer[m][n][maxMove];
        
        int paths = 0;
        for(int k = 1; k <= maxMove; k++) {
            paths += checkPaths(startRow, startColumn, memo, k);
            paths %= MODULO;
        }
        
        return paths;  
    }
    
    private int checkPaths(int i, int j, Integer[][][] memo, int k){
        if(i < 0 || j < 0 || i >= m || j >= n) {
            if(k == 0) return 1;
            else return 0;
        }
        
        if(k == 0) return 0;
        
        if(memo[i][j][k - 1] != null) return memo[i][j][k - 1];
        
        // 4 directions
        int numOfPaths = 0;
        for(int[] dir: directions){
            numOfPaths += checkPaths(i + dir[0], j + dir[1], memo, k - 1);
            numOfPaths %= MODULO;
        }
        
        memo[i][j][k - 1] = numOfPaths;
        return numOfPaths;
    }
}

        // Ball can go in 4 directions - up down left right
        
        // If max move = k --> Try 1 .. k steps to get the possiblities 
                // For(1..k)
        // use a memo[m][n][k] -> 
        // if m || n out of bound -> return 1
        // if k == 0 -> return 0