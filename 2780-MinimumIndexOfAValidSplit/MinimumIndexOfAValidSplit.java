import java.util.*; 

public class MinimumIndexOfAValidSplit {
    class Solution {
        public int minimumIndex(List<Integer> nums) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            int n = nums.size();
            int x = -1;

            for (int i = 0; i < n; i++) {
                freq.put(nums.get(i), freq.getOrDefault(nums.get(i), 0) + 1);

                if (freq.get(nums.get(i)) > nums.size() / 2) {
                    x = nums.get(i);
                }
            }

            if (x == -1)
                return x;

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums.get(i) == x)
                    count++;

                if ((count > (i + 1) / 2) && ((freq.get(x) - count) > ((n - i - 1) / 2)))
                    return i;
            }

            return -1;
        }
    }
}