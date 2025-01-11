import java.util.*;

class SetMismatch {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int dup = -1;
    
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++) {
                if(set.contains(nums[i])) {
                    dup = nums[i];
                }
                set.add(nums[i]);
            }
             
            for(int i = 1; i <= nums.length; i++){
                if(!set.contains(i)){
                    return new int[]{dup, i};
                }
            }
            return new int[]{};
        }
    }
}
