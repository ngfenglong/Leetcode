public class MaximumValueOfAnOrderedTripletII {
    class Solution {
        public long maximumTripletValue(int[] nums) {
            int n = nums.length;
            int[] maxLeft = new int[n];
            int[] maxRight = new int[n];

            for (int i = 1; i < n - 1; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1], nums[i - 1]);
                maxRight[n - i - 1] = Math.max(maxRight[n - i], nums[n - i]);
            }

            long ans = 0l;
            for (int i = 1; i < n - 1; i++) {
                long temp = (long) (maxLeft[i] - nums[i]) * (long) maxRight[i];
                ans = Math.max(temp, ans);
            }

            return ans;
        }
    }
}