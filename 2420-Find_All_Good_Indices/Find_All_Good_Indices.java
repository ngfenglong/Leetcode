import java.util.*;

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        boolean[] isNonIncreasingCheck = new boolean[n];
        boolean[] isNonDecreasingCheck = new boolean[n];
        
        int count = 1;
        for(int i = 1; i < n; i++){
            if(count >= k) isNonIncreasingCheck[i] = true;
            if(nums[i] <= nums[i - 1]) count++;
            else count = 1;
        } 
        
        count = 1;
        for(int i = n - 2; i >= 0; i--){
            if(count >= k) isNonDecreasingCheck[i] = true;
            if(nums[i + 1] >= nums[i]) count++;
            else count = 1;
        } 

        List<Integer> ans = new ArrayList<>();
        for(int i = k; i < n - k; i++){
            if(isNonIncreasingCheck[i] && isNonDecreasingCheck[i]) ans.add(i);
        }
 
        return ans;
    }
}
