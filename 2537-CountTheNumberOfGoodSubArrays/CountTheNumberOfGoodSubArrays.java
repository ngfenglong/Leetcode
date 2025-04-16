import java.util.*;

public class CountTheNumberOfGoodSubArrays {
    class Solution {
        public long countGood(int[] nums, int k) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            int start = 0;
            long count = 0;
            int pairs = 0;

            for (int end = 0; end < nums.length; end++) {
                int endVal = freq.getOrDefault(nums[end], 0) + 1;
                freq.put(nums[end], endVal);

                pairs += (endVal - 1); // Add if there is at least one pair

                while (start < end && pairs >= k) {
                    count += (long) (nums.length - end);

                    int startVal = freq.get(nums[start]);
                    pairs -= (startVal - 1);

                    freq.put(nums[start], startVal - 1);
                    start++;
                }
            }

            return count;
        }
    }
}