import java.util.*;

class FirstCompletelyPaintedRowOrColumn{
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
    
            HashMap<Integer, int[]> idxMap = new HashMap<>();  // Num, [idx row, idx col]
            int[] rowColored = new int[m];
            int[] colColored = new int[n];
    
    
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    int num = mat[i][j];
                    idxMap.put(num, new int[]{i, j});
                }
            }
    
            for(int i = 0; i < m * n; i++){
                int num = arr[i];
                int[] indexes = idxMap.get(num);
    
                rowColored[indexes[0]]++;
                colColored[indexes[1]]++;
    
                if (rowColored[indexes[0]] == n || colColored[indexes[1]] == m) return i;
            }
    
            return -1;
    
        }
    }
}

