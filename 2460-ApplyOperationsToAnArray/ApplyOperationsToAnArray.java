public class ApplyOperationsToAnArray {
    class Solution {
        public int[] applyOperations(int[] nums) {
            int[] ans = new int[nums.length];
            int endP = nums.length - 1;
            int startP = 0;
    
            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] == nums[i + 1]){
                    nums[i + 1] = 0;
                    nums[i] *= 2;
                }
                
                if(nums[i] == 0){
                    ans[endP--] = nums[i]; 
                } 
                else {
                    ans[startP++] = nums[i];
                }
            }
            ans[startP] = nums[nums.length - 1];
            
            return ans;
        }
    }
}