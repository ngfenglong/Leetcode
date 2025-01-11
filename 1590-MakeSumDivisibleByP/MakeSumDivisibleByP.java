import java.util.*;

class MakeSumDivisibleByP {
    
    class Solution {
        public int minSubarray(int[] nums, int p) {
            int sumMod = 0;
            
            for(int i = 0 ; i < nums.length; i++){
                sumMod = (sumMod + nums[i]) % p;
            }
            
            if(sumMod == 0) return 0;
            
            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(0, -1);
            
            int min = nums.length;
            int currSum = 0;
            
            for(int i = 0; i < nums.length; i++){
                currSum = (currSum + nums[i]) % p;
                int needed = (currSum - sumMod + p) % p;
                
                if(hm.containsKey(needed)) {
                    min = Math.min(min, i - hm.get(needed));
                }
                
                hm.put(currSum, i);
            }
            
            if(min == nums.length) return -1;        
            return min;
        }
    }
}
