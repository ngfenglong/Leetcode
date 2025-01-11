
class NumberOfWaysToSplitArray {
    class Solution {
        public int waysToSplitArray(int[] nums) {
            long[] sumup = new long[nums.length];
    
            sumup[0] = nums[0];
    
            for(int i = 1; i < nums.length; i++){
                sumup[i] += sumup[i - 1] + nums[i];
            }
    
            int count = 0;
            for(int i = 0; i < nums.length - 1; i++){
                if(sumup[i] >= sumup[nums.length - 1] - sumup[i]) count++;
            }
    
            return count;
        }
    }
}
