class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
           // To handle all negative numbers
           if(nums[i] > max){
               max = nums[i];
           } 
           if(currSum + nums[i] < 0){
               currSum = 0;
           }
           else{
               currSum += nums[i];
               max = Math.max(max, currSum);
           }
        }
        return max;
    }
} 