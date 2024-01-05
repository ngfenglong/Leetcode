class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] counts = new int[nums.length];
        int max = 1;
        counts[nums.length - 1]++;
        
        for(int i = nums.length - 2; i >= 0; i--){
            int count = 1;
            for(int j = nums.length - 1; j > i; j--){
                if(nums[i] < nums[j]){
                    count = Math.max(count, (counts[j] + 1));
                }
            }
            counts[i] = count;
            max = Math.max(count, max);
        }
        
        return max;
    }
}