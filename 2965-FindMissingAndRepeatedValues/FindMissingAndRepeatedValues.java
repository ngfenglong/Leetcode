public class FindMissingAndRepeatedValues {
    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            int missing = -1;
            int duplicate = -1;
            boolean[] visited = new boolean[n*n];
    
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visited[grid[i][j] - 1]){
                        duplicate = grid[i][j];
                    }
                    visited[grid[i][j] - 1] = true;
                }
            }
    
            for(int i = 0; i < visited.length; i++){
                if(visited[i] == false){
                    missing = i + 1;
                }
            }
    
            return new int[]{duplicate, missing};
        }
    }
}