import java.util.*;

public class MaxSumOfAPairWithEqualSumOfDigits {
    class Solution {
        public int maximumSum(int[] nums) {
            int ans = -1;
    
            HashMap<Integer, int[]> sumIdxMap = new HashMap<>();
    
            for(int i = 0 ; i < nums.length; i++){
                int sum = calculateSum(nums[i]);
                
                if(!sumIdxMap.containsKey(sum)) sumIdxMap.put(sum, new int[]{-1, -1});
    
                int[] top2 = sumIdxMap.get(sum);
                if(nums[i] > top2[0]){
                    top2[1] = top2[0];
                    top2[0] = nums[i];
                }
                else if(nums[i] > top2[1]){
                    top2[1] = nums[i];
                }
            }
    
            for(Integer sum: sumIdxMap.keySet()){
                int[] top2 = sumIdxMap.get(sum);
    
                if(top2[1] > -1){
                    ans = Math.max(ans, top2[0] + top2[1]);
                }
            }
    
            return ans;
        }
    
        private int calculateSum(int num){
            int curr = 0;
            while(num > 0){
                curr += (num % 10);
                num /= 10;
            }
    
            return curr;
    
        }
    }
}
