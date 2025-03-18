public class LongestNiceSubarray {
    class Solution {
        public int longestNiceSubarray(int[] nums) {
            int max = 0;
    
            int start = 0;
            int bitsUsed = 0;
            for(int end = 0; end < nums.length; end++){
                while((bitsUsed & nums[end]) != 0){
                    bitsUsed ^= nums[start];
                    start++;
                }
    
                bitsUsed |= nums[end];
                max = Math.max(max, end - start + 1);
            }   
    
            return max;
        }
    }
}