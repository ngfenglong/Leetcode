import java.util.*;

class FrogJump {
    class Solution {
        Boolean[][] dp;
        HashMap<Integer, Integer> hm = new HashMap<>();
        public boolean canCross(int[] stones) {
            if(stones[1] != 1 || stones[stones.length - 1] > 2001000) return false;
            
            // We use the idx of stones and k as the identifier - so that it wont hit exceed memory limit
            dp = new Boolean[2001][2001];
            
            for(int i = 0 ; i < stones.length; i++){
                hm.put(stones[i], i);   // Store the index for each stone's position - to use for memoization
            }
            return checkSteps(1, 0, stones[stones.length-1]);
        }
        
        private boolean checkSteps(int k, int pos, int last){
            if(pos == last) return true;
            if(!hm.containsKey(pos)) return false;  // There is no stone at the position
            
            int idx = hm.get(pos);
            
            if (dp[idx][k] != null) return dp[idx][k];      // Check memoization
            
            boolean check = false;
            check = check || (k != 1 && checkSteps(k - 1, pos + (k - 1),last)); // To previent infinite loop
            check = check || checkSteps(k, pos + k, last);
            check = check || (idx != 0 && checkSteps(k + 1, pos + k + 1, last));    // For first stone, you can onlu take 1 step. 
            
            dp[idx][k] = check;
    
            return check;
        }
    }
}
