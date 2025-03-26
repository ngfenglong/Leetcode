import java.util.*;

public class MinimumOperationsToMakeAUniValueGrid {
    class Solution {
        public int minOperations(int[][] grid, int x) {        
            int rows = grid.length;
            int cols = grid[0].length;

            int remainder = grid[0][0] % x;
    
            List<Integer> list = new ArrayList<>();            
    
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if((grid[i][j] % x) != remainder) return -1;
                    list.add(grid[i][j]);
                }
            }
    
            Collections.sort(list);

            int medianVal = list.get(list.size()/ 2);
            int operations = 0;
            
            for(Integer val: list){
                operations += (Math.abs((medianVal - val)/ x));
            }
    
            return operations;
        }
    }    
}