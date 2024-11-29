class Solution {
    private final int[][] DIRECTIONS = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public int minimumTime(int[][] grid) {
        // Handle edge cases
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        
        int m = grid.length;
        int n = grid[0].length;        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2])); // x, y, time
        
        queue.add(new int[]{0,0,0});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            
            if(x == m-1 && y == n - 1) return curr[2];
            
            if(visited[x][y]) continue;
            
            visited[x][y] = true;
            
            for(int[] direction: DIRECTIONS){
                int newX = x + direction[0];
                int newY = y + direction[1];
                
                if(newX >= m || newX < 0 || newY >= n || newY < 0 || visited[newX][newY]){
                    continue;
                } 
                
                int minTime = (grid[newX][newY] - curr[2]) % 2 == 0 ? 1 : 0;
                int timeTaken = Math.max(grid[newX][newY] + minTime, curr[2] + 1);
                queue.add(new int[]{newX, newY, timeTaken});   
            }
        }
    
        return -1;
    }
}