class CheckIfArrayIsSortedAndRotated{
    class Solution {
        public boolean check(int[] nums) {
            int inverseCount = 0; 
            int n = nums.length;
    
            for(int i = 0; i < n - 1; i++){
                if(nums[i] > nums[i + 1]) inverseCount++;
            }
    
            if(nums[0] < nums[n-1]) inverseCount++;
    
            return inverseCount <= 1;
        }
    }
}
