import java.util.*;

public class PartitionEqualSubsetSum {
    class Solution {
        public boolean canPartition(int[] nums) {
            int total = 0;

            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
            }

            if (total % 2 == 1)
                return false;

            Arrays.sort(nums);

            if (nums[nums.length - 1] > total / 2)
                return false;

            return hasSubsetSum(nums, total / 2, 0, new Boolean[nums.length][total / 2 + 1]);
        }

        private boolean hasSubsetSum(int[] nums, int target, int idx, Boolean[][] dp) {
            if (target == 0)
                return true;
            if (idx >= nums.length || nums[idx] > target)
                return false;
            if (dp[idx][target] != null)
                return dp[idx][target];

            boolean option = hasSubsetSum(nums, target - nums[idx], idx + 1, dp);
            option = option || hasSubsetSum(nums, target, idx + 1, dp);

            dp[idx][target] = option;
            return option;
        }
    }
}