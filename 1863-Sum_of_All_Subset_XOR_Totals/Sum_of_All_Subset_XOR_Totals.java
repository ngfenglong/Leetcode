class Solution {
    public int subsetXORSum(int[] nums) {
        return findSum(nums, 0, 0);
    }

    private int findSum(int[] nums, int i, int curr) {
        if (i == nums.length) return curr;
        
        int sum1 = findSum(nums, i + 1, curr ^ nums[i]);
        int sum2 = findSum(nums, i + 1, curr);

        return sum1 + sum2;
    }
}