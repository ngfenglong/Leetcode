import java.util.*;
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int[] min = new int[]{Integer.MAX_VALUE, -1};
        int[] secondMin = new int[]{Integer.MAX_VALUE, -1};
        int[] max = new int[]{Integer.MIN_VALUE, -1};
        int[] secondMax = new int[]{Integer.MIN_VALUE, -1};
        
        for(int i = 0; i < arrays.size(); i++){
            int localMin = arrays.get(i).get(0);
            int localMax = arrays.get(i).get(arrays.get(i).size() - 1);
            
            if(localMin <= min[0]){
                secondMin[0] = min[0];
                secondMin[1] = min[1];
                min[0] = localMin;
                min[1] = i;
            }
            else if(localMin < secondMin[0]){
                secondMin[0] = localMin;
                secondMin[1] = i;
            }
            
            if(localMax >= max[0]){
                secondMax[0] = max[0];
                secondMax[1] = max[1];
                max[0] = localMax;
                max[1] = i;
            }
            else if(localMax > secondMax[0]){
                secondMax[0] = localMax;
                secondMax[1] = i;
            }
        }
        
        if(min[1] == max[1]){
            return Math.max(max[0] - secondMin[0], secondMax[0] - min[0]);
        }
        else {
            return max[0] - min[0];
        }
    }
}