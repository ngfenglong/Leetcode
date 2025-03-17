import java.util.*;

public class DivideArrayIntoEqualPairs {
    class Solution {
        public boolean divideArray(int[] nums) {
            HashMap<Integer, Integer> freqs = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                freqs.put(nums[i], freqs.getOrDefault(nums[i], 0) + 1);
            }

            for (int key : freqs.keySet()) {
                if (freqs.get(key) % 2 != 0)
                    return false;
            }

            return true;
        }
    }
}