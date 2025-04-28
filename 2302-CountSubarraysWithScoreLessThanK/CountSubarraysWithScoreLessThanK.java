public class CountSubarraysWithScoreLessThanK {
    class Solution {
        public long countSubarrays(int[] nums, long k) {
            long ans = 0l;
            long sum = 0l;

            int start = 0;
            for (int end = 0; end < nums.length; end++) {
                sum += nums[end];
                while (start <= end && (sum * (end - start + 1)) >= k) {
                    sum -= nums[start];
                    start++;
                }

                ans += (end - start + 1);
            }

            return ans;
        }
    }

}