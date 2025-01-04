import java.util.*;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                int curr = hm.get(nums[i]);
                hm.put(nums[i],curr + 1);
                count += curr;
            } else{
                hm.put(nums[i],1);
            }
        }
        
        return count;
    }
}