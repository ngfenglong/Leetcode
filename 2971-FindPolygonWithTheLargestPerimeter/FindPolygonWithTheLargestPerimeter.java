import java.util.*;

class FindPolygonWithTheLargestPerimeter {
    
    class Solution {
        public long largestPerimeter(int[] nums) {
            long max = -1l;
            Arrays.sort(nums);
            
            long currSum = (long)nums[0];
            
            for(int i = 1; i < nums.length; i++) {
                if(currSum > (long)nums[i]) {
                    max = currSum + nums[i];
                }
                
                currSum += (nums[i]);
            }
            
            return max;
            
        }
    }
}
