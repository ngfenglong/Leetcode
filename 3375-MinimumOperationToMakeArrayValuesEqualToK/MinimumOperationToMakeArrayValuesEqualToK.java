import java.util.*;

public class MinimumOperationToMakeArrayValuesEqualToK {
    class Solution {
        public int minOperations(int[] nums, int k) {
            int minVal = Integer.MAX_VALUE;
            Set<Integer> uniqueVal = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (k > nums[i])
                    return -1;

                minVal = Math.min(nums[i], minVal);
                uniqueVal.add(nums[i]);
            }

            return minVal == k ? uniqueVal.size() - 1 : uniqueVal.size();
        }
    }
}