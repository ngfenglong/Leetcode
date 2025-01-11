import java.util.*;

class DivideArrayIntoArraysWithMaxDifference {
    
    class Solution {
        public int[][] divideArray(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int grp = n / 3;
            int[][] ans = new int[grp][3];
            
            int i = nums.length - 1;
            
            while(i > 0){
                if(nums[i] - nums[i-2] > k) return new int[][]{};
                
                for(int j = 0; j < 3; j++){
                    ans[grp - 1][2 - j] = nums[i - j];
                }
                
                i -= 3;
                grp--;
            }
            
            return ans;
        }
    }
}
