public class MaximumValueOfAnOrderedTripletI {
    class Solution {
        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            int[] leftMax = new int[nums.length];
            int[] rightMax = new int[nums.length];

            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
                rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
            }

            long ans = 0l;
            for (int i = 1; i < nums.length - 1; i++) { // Traverse for the middle number
                long temp = (long) (leftMax[i] - nums[i]) * (long) rightMax[i];
                ans = Math.max(temp, ans);
            }

            return ans;
        }
    }

}