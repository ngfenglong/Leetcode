
class MonotonicArray {
    class Solution {
        public boolean isMonotonic(int[] nums) {
            Boolean isIncreasing = null;
            if(nums.length == 1) return true;
            
            int prev = nums[0];
            for(int i = 1; i < nums.length; i++){
                if(nums[i] > prev){
                    if(isIncreasing != null && isIncreasing == false) return false;
                    isIncreasing = true;
                }
                if(nums[i] < prev){
                    if(isIncreasing != null && isIncreasing == true) return false;
                    isIncreasing = false;
                }
                prev = nums[i];
            }
            return true;
        }
    }
}
