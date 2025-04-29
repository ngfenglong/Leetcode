public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    class Solution {
        public long countSubarrays(int[] nums, int k) {
            int maxElement = -1;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > maxElement) {
                    maxElement = nums[i];
                    count = 1;
                } else if (maxElement == nums[i])
                    count++;
            }

            if (count < k)
                return 0l;

            long ans = 0l;
            int start = 0;
            int occur = 0;

            for (int end = 0; end < nums.length; end++) {
                if (nums[end] == maxElement)
                    occur++;

                while (start <= end && occur == k) {
                    ans += (long) (nums.length - end);
                    if (nums[start] == maxElement)
                        occur--;
                    start++;
                }
            }

            return ans;
        }
    }

}