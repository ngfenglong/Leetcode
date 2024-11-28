class Solution {
    final int[][] DIRECTIONS = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        
        PriorityQueue<Step> pq = new PriorityQueue<Step>(new Comparator<Step>(){
            public int compare(Step s1, Step s2){
                return Integer.compare(s1.cost, s2.cost);
            }
        });
        pq.add(new Step(0,0,0));
        
        while(!pq.isEmpty()){
            Step step = pq.poll();
            int x = step.x;
            int y = step.y;
            int cost = step.cost;
            
            if(x == m - 1 && y == n - 1) return step.cost;
            
            if(dp[x][y]) continue;
            
            
            dp[x][y] = true;
            for(int[] direction: DIRECTIONS){
                int newX = x + direction[0];
                int newY = y + direction[1];
                
                if(newX < m && newX >= 0 && newY < n && newY >= 0){
                    pq.add(new Step(newX, newY, cost + grid[x][y]));
                }
            } 
            
        }
        
        
        return -1;
    }
    
    public class Step{
        int cost;
        int x;
        int y;
        
        public Step(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}