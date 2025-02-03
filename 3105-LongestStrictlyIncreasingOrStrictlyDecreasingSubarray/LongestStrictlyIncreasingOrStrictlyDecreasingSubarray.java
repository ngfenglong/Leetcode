class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int currDecreasing = nums[0];
            int decreasingCount = 1;

            int currIncreasing = nums[0];
            int increasingCount = 1;

            int max = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > currIncreasing) {
                    increasingCount++;
                    max = Math.max(max, increasingCount);
                } else {
                    increasingCount = 1;
                }

                if (nums[i] < currDecreasing) {
                    decreasingCount++;
                    max = Math.max(max, decreasingCount);
                } else {
                    decreasingCount = 1;
                }

                currIncreasing = nums[i];
                currDecreasing = nums[i];
            }

            return max;
        }
    }
}