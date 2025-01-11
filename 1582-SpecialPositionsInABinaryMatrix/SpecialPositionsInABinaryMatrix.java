import java.util.*;

class SpecialPositionsInABinaryMatrix {
    
    class Solution {
        public int numSpecial(int[][] mat) {
            List<Integer> specialCol = new ArrayList<>();
            
            for(int i = 0; i < mat.length; i++){
                int check = 0;
                int col = -1;
                for(int j = 0; j < mat[i].length; j++){
                    if(mat[i][j] == 1) {
                        check++;
                        col = j;
                    }
                }
                
                if (check == 1){
                    specialCol.add(col);
                }
            }
            
            int ans = 0;
            for(Integer j: specialCol){
                int check = 0;
                for(int i = 0; i < mat.length; i++){
                    if(mat[i][j] == 1) check++;
                }
                if (check == 1){
                    ans++;
                }
            }
                
            return ans;
        }
    }
}
