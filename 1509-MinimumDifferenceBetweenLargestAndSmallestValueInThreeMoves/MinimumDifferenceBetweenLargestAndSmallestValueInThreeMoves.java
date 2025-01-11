import java.util.*;

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    
    class Solution {
        public int minDifference(int[] nums) {
            int steps = 3;
            if(nums.length <= steps) return 0;
            
            Arrays.sort(nums);
            int p1 = 0 ;
            int p2 = nums.length - 1;
            
            return findMin(nums, p1, p2, steps);
           
        }
        
        private int findMin(int[] nums, int p1, int p2, int steps){
            if(steps == 0) return nums[p2] - nums[p1];
            
            int min1 = findMin(nums, p1 + 1, p2, steps - 1);
            int min2 = findMin(nums, p1, p2 - 1, steps - 1);
            
            return Math.min(min1, min2);
        }
    }
}
