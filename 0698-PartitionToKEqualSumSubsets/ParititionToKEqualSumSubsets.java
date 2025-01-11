import java.util.*;

class ParititionToKEqualSumSubsets {
    
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int total = 0;
            for(int i = 0; i < nums.length; i++){
                total += nums[i];
            }
            
            if(total % k != 0) return false;
            
            int target = total / k;
            
            Arrays.sort(nums);
            reverseOrder(nums);
    
            return dfs(0, target, 0, k, 0, nums, new boolean[nums.length]);
        }
        
        // We will clear 1 by 1 till we have k number of target;
        private boolean dfs(int idx, int target, int currSum, int k, int count, int[] nums, boolean[] visited){
            if(count == k) return true;
        
            if(currSum == target){
                // go to the next target
                return dfs(0, target, 0, k, count + 1, nums, visited);
            }
            
            if(currSum > target) return false;
            
            
            for(int i = idx; i < nums.length; i++) {
                if(visited[i] == false){
                    visited[i] = true;
                    if(dfs(i + 1, target, currSum + nums[i], k, count, nums, visited)){
                        return true;   
                    } 
                    visited[i] = false;
                }
            }
            
            return false;
        }
        
        private void reverseOrder(int[] arr){
            for(int i = 0; i < arr.length/2; i++){
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
        }
    }
}
