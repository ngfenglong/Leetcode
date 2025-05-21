import java.util.*;

public class SetMatrixZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> rowToZero = new HashSet<>();
            Set<Integer> columnToZero = new HashSet<>();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        rowToZero.add(i);
                        columnToZero.add(j);
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (rowToZero.contains(i) || columnToZero.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }
}