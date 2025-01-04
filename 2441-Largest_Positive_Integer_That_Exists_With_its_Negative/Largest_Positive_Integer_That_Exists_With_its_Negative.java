import java.util.*;

class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> checkList = new HashSet<Integer>();
        
        for(int i: nums){
            checkList.add(i);
        }
        
        int max = -1;
        for(int i: nums){
            if(i > 0 && checkList.contains(0 - i)){
                max = Math.max(i , max);
            }
        }
        return max;
    }
}