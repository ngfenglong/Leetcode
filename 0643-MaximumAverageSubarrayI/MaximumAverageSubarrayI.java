public class MaximumAverageSubarrayI {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int start = 0;
            double sum = 0;
    
            for(int end = 0; end < k; end ++){
                sum += nums[end];
            }
    
            double max = sum;
    
            for(int end = k; end < nums.length; end++){
                sum += nums[end];
                sum -= nums[start++];
                
                max = Math.max(max, sum);
            }
    
            return max / k;
        }
    }
}