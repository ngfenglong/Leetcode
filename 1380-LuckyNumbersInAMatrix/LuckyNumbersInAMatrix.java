import java.util.*;

class LuckyNumbersInAMatrix {
    
    class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            
            int[] lowestRowPos = new int[m];
            for(int i = 0; i < m; i++){
                int idx = -1;
                int val = Integer.MAX_VALUE;
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] < val){
                        val = matrix[i][j];
                        idx = j;
                    }
                }
                lowestRowPos[i] = idx;
            }
            
            for(int i = 0; i < m; i++){
                int col = lowestRowPos[i];
                int val = matrix[i][col];
                boolean isBiggest = true;
                
                for(int j = 0; j < m; j++){
                    if(matrix[j][col] > val) isBiggest = false; 
                }
                
                if(isBiggest) ans.add(val);
            }
            
            return ans;
        }
    }
}
