import java.util.*;

public class CountCompleteSubarraysInAArray {
    class Solution {
        public int countCompleteSubarrays(int[] nums) {
            Set<Integer> distinctSet = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                distinctSet.add(nums[i]);
            }

            int count = 0;
            int start = 0;
            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int end = 0; end < nums.length; end++) {
                int val = nums[end];
                freq.put(val, freq.getOrDefault(val, 0) + 1);
                while (start <= end && freq.keySet().size() == distinctSet.size()) {
                    count += (nums.length - end);

                    int startVal = nums[start];
                    freq.put(startVal, freq.get(startVal) - 1);

                    if (freq.get(startVal) == 0)
                        freq.remove(startVal);

                    start++;
                }
            }

            return count;
        }
    }
}