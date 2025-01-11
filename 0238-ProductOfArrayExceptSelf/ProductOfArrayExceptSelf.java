import java.util.*;

class ProductOfArrayExceptSelf {
    
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] ans = new int[nums.length];
            
            int total = 1;
            Set<Integer> zeroIdx = new HashSet<Integer>();
            
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0)
                    zeroIdx.add(i);
                else
                    total *= nums[i];
            }
            
            
            if(zeroIdx.size() > 1){
                return ans;
            }
            else if(zeroIdx.size() == 1){
                List<Integer> list = new ArrayList<>(zeroIdx);
                ans[list.get(0)] = total;
            }
            else{
                for(int i = 0; i < nums.length; i++){
                    ans[i] = total / nums[i];
                }
            }
            return ans;
        }
    }
}
