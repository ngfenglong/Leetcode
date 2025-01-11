
class SpecialArrayII {
    class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            int n = nums.length;
            int[] maxReach = new int[n];
            int end = 0;
            
            for(int i = 0; i < n; i++){
                end = Math.max(i, end);
                
                while (end < n - 1 && nums[end] % 2 != nums[end + 1] % 2){
                    end++;
                }
                
                maxReach[i] = end;
            }
    
            boolean[] ans = new boolean[queries.length];
            
            for(int i = 0; i < queries.length; i++){
                int start = queries[i][0];
                end = queries[i][1];
                
                ans[i] = end <= maxReach[start];            
            }
            
            return ans;
        }
    }
}
