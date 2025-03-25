import java.util.*;

public class CheckIfGridCanBeCutIntoSections {
    class Solution {
        public boolean checkValidCuts(int n, int[][] rectangles) {
            Arrays.sort(rectangles, (a, b) -> Integer.compare(a[0],b[0]));
            boolean sliceable = checkSliceable(rectangles, 0, 2);
    
            if(sliceable) return true;
    
            Arrays.sort(rectangles, (a, b) -> Integer.compare(a[1],b[1]));
            sliceable = checkSliceable(rectangles, 1, 3);
    
            return sliceable;
        }
    
        private boolean checkSliceable(int[][] rectangles, int startIdx, int endIdx){
            int slice = 0;
            int currEnd = rectangles[0][endIdx];
    
            for(int i = 1; i < rectangles.length; i++){
                if(rectangles[i][startIdx] < currEnd){
                    currEnd = Math.max(rectangles[i][endIdx], currEnd);
                }
                else{
                    slice++;
                    currEnd = rectangles[i][endIdx];
                    if(slice == 2) return true;
                }
            }
    
            return false;
        }
    }
}