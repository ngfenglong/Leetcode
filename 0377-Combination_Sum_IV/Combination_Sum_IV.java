import java.util.*;

class Solution {
    Integer[] dp;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dp = new Integer[target + 1];

        return checkSum(nums,target);
    }
    
    private int checkSum(int[] nums, int target){
        if(target == 0) return 1;
        
        if(target < 0) return 0;
        
        if(dp[target] != null) return dp[target];
        
        int ans = 0; 
        for(int i: nums){
            ans += checkSum(nums, target - i);
        }
        
        dp[target] = ans;
        return ans;
    }
}