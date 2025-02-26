public class MaximumAbsoluteSumOfAnySubarray {
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int minPrefixSum = 0;
            int maxPrefixSum = 0;
            int prefixSum = 0;
        
            for(int i = 0; i < nums.length; i++){
                prefixSum += nums[i];
    
                minPrefixSum = Math.min(prefixSum, minPrefixSum);
                maxPrefixSum = Math.max(prefixSum, maxPrefixSum);
            }
        
            return maxPrefixSum - minPrefixSum;
        }
    }
}
