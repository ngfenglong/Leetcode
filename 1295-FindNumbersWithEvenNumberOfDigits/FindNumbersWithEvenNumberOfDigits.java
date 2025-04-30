public class FindNumbersWithEvenNumberOfDigits {
    class Solution {
        public int findNumbers(int[] nums) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                if ((val >= 10 && val < 100) ||
                        (val >= 1000 && val < 10000) ||
                        (val == 100000))
                    count++;
            }

            return count;
        }
    }

}