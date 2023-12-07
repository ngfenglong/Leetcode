class Solution {
    public int maxDistance(int[][] grid) {
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer,Integer>>();
        
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length;  j++){
                if(grid[i][j] == 1) q.add(new Pair<Integer, Integer>(i, j));
            }
        }
        
        int ans = -1;   // All water
        while(!q.isEmpty()){
            int count = q.size();
            
            while(count >0){
                Pair<Integer,Integer> p = q.poll();
                int i = p.getKey();
                int j = p.getValue();
                
                if(i > 0 && grid[i-1][j] == 0) {
                    grid[i-1][j] = 1;
                    q.add(new Pair(i - 1, j));
                }
                if(j > 0 && grid[i][j-1] == 0){
                    grid[i][j-1] = 1; 
                    q.add(new Pair(i, j - 1));  
                } 
                if(i < grid.length - 1 && grid[i+1][j] == 0){
                    grid[i+1][j] = 1;
                    q.add(new Pair(i + 1, j));
                    
                } 
                if(j < grid[0].length - 1 && grid[i][j+1] == 0) {
                    grid[i][j+1] = 1;
                    q.add(new Pair(i , j + 1));   
                }
               
                count--;
            }
            
            ans++;
        }
        
        return ans == 0 ? -1 : ans;
    }
}