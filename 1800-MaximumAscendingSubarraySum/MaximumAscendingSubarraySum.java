class MaximumAscendingSubarraySum {
    class Solution {
        public int maxAscendingSum(int[] nums) {
            int max = 0;
            int prev = 0;
            int cummulative = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > prev) {
                    cummulative += nums[i];
                } else {
                    cummulative = nums[i];
                }

                max = Math.max(cummulative, max);
                prev = nums[i];
            }

            return max;
        }
    }
}