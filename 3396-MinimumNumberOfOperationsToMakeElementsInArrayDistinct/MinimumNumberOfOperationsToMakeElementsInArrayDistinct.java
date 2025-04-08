import java.util.*;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    class Solution {
        public int minimumOperations(int[] nums) {
            int operations = 0;
            int n = nums.length;

            Set<Integer> distinctInt = new HashSet<>();
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                distinctInt.add(nums[i]);
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            }

            if (n == distinctInt.size())
                return operations;

            int idx = 0;
            while (idx < n && n - idx > distinctInt.size()) {
                for (int i = 0; i < 3; i++) {
                    if (idx < n) {
                        int val = freq.get(nums[idx]);
                        if (val == 1) {
                            distinctInt.remove(nums[idx]);
                        }
                        freq.put(nums[idx], val - 1);
                    }
                    idx++;
                }
                operations++;
            }

            return operations;
        }
    }

}