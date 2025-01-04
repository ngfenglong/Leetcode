import java.util.*;


class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        
        Set<Integer> occur = new HashSet<>();
        for(Integer key: hm.keySet()) {
            int val = hm.get(key);
            if(occur.contains(val)) return false;
            
            occur.add(val);
        }
        
        return true;
    }
}