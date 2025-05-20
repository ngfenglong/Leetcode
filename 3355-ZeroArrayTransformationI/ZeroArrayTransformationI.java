public class ZeroArrayTransformationI {
    class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int[] deductsArr = new int[nums.length + 1];

            for (int i = 0; i < queries.length; i++) {
                deductsArr[queries[i][0]]++;
                deductsArr[queries[i][1] + 1]--;
            }

            int deduct = 0;
            for (int i = 0; i < nums.length; i++) {
                deduct += deductsArr[i];
                if (nums[i] > deduct)
                    return false;
            }

            return true;
        }
    }
}