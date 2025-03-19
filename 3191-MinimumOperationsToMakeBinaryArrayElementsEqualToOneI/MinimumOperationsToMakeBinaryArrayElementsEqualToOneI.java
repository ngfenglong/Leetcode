public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    class Solution {
        public int minOperations(int[] nums) {
            // naive approach, if nums[i] == 0 && i < nums.length - 2, flip nums[i+1]. 
            // If nums[length - 1 ] == 1 && nums[length - 1 ] == 1; return count. Else return -1
            
            int count = 0;
            for(int i = 0; i < nums.length - 2; i++){
                if(nums[i] == 0){
                    for(int j = 0; j < 3; j++){
                        nums[i + j] = (nums[i + j] + 1) % 2;
                    }
    
                    count++;
                }
            }
    
            if(nums[nums.length - 1] == 1 && nums[nums.length - 2] == 1) return count;
    
            return -1;
        }
    }
}