import java.util.*;


class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for(int i: banned){
            bannedSet.add(i);
        }
        
        int count = 0;
        int sum = 0;
        
        for(int i = 1; i <= n; i++){
            if(!bannedSet.contains(i)){
                sum += i;
                if(sum > maxSum) return count;
                
                count++;
            }
        }
        
        return count;
        
    }
}