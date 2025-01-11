
class SubarrayProductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int leftP = 0;
            int rightP = 0;
            
            int curr = 1;
            int count = 0;
            while(rightP < nums.length){
                curr *= nums[rightP];
                
                while(leftP <= rightP && curr >= k){
                    curr /= nums[leftP++];
                }
                
                count += (rightP - leftP + 1);
                rightP++;
            }
            
            return count;
        }
    }
}
