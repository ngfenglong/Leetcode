import java.util.*;
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] == a[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int i = 0;
        int count = 0;
        int currMax = points[0][1];
        
        while(i < points.length){
            if(points[i][0] > currMax){
                count++;
                currMax = points[i][1];
            }
            i++;
        }
        
        return count + 1;
    }
}