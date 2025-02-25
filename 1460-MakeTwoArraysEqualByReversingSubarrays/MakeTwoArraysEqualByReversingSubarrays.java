import java.util.*;

public class MakeTwoArraysEqualByReversingSubarrays {
    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            if(target.length != arr.length) return false;
    
            int n = target.length;    
            HashMap<Integer, Integer> hm = new HashMap<>();
    
            for(int i = 0; i < n; i++){
                int val = target[i];
                hm.put(val, hm.getOrDefault(val, 0) + 1);
            }
            
            for(int i = 0; i < n; i++){
                int val = arr[i];
                
                if(!hm.containsKey(val) || hm.get(val) == 0) return false;
    
                hm.put(val, hm.get(val) - 1);
            }
            
            return true;
        }
    }
}